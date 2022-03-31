package com.jinyeob.eqt

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.tabs.TabLayoutMediator
import com.jinyeob.domain.model.CheckItem
import com.jinyeob.domain.model.MccheyneItem
import com.jinyeob.eqt.ExtensionMethods.toShortBible
import com.jinyeob.eqt.MyApplication.Companion.TAG
import com.jinyeob.eqt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            viewModel.mccheyneFlow.collect { mccheyneItem ->
                setViews(mccheyneItem)
            }
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun setViews(mccheyneItem: MccheyneItem) {
        if (mccheyneItem.plan.isEmpty()) return

        val todayKey = SimpleDateFormat("M-dd").format(Date(System.currentTimeMillis()))

        val checkItems = mccheyneItem.plan[todayKey]

        val checkItemTitles = getCheckItemTitles(checkItems)
        val fragmentList = getMccheyneSingleFragments(checkItems)

        setViewPagerAndTabLayout(fragmentList, checkItemTitles)
    }

    private fun getCheckItemTitles(checkItems: List<CheckItem>?): MutableList<String> {
        val checkItemTitles = mutableListOf<String>()
        checkItems?.forEach { checkItem ->
            if (checkItems.filter { it.book == checkItem.book }.size >= 2) {
                checkItemTitles.add("${checkItem.book.toShortBible()}${checkItem.chapter}:${checkItem.verses.first().verse}~${checkItem.verses.last().verse}")
            } else {
                checkItemTitles.add(checkItem.book.toShortBible())
            }
        }
        return checkItemTitles
    }

    private fun getMccheyneSingleFragments(checkItems: List<CheckItem>?): MutableList<Fragment> {
        val fragmentList = mutableListOf<Fragment>()
        checkItems?.forEach {
            fragmentList.add(MccheyneSingleFragment(it))
        }
        return fragmentList
    }

    private fun setViewPagerAndTabLayout(
        fragmentList: MutableList<Fragment>,
        checkItemTitles: MutableList<String>
    ) {
        with(binding) {
            readPageBottomViewpager.adapter = ReadPageBottomViewPagerFragmentAdapter(
                this@MainActivity,
                fragmentList
            )
            TabLayoutMediator(
                readPageTablayout,
                readPageBottomViewpager
            ) { tab, position ->
                tab.text = checkItemTitles[position]
            }.attach()
        }
    }
}
