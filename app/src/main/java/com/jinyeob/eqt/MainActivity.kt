package com.jinyeob.eqt

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.tabs.TabLayoutMediator
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

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            viewModel.mccheyneFlow.collect { mccheyneItem ->
                if (mccheyneItem.plan.isNotEmpty()) {
                    val planMap = mccheyneItem.plan

                    val date = Date(System.currentTimeMillis())
                    val todayKey = SimpleDateFormat("M-dd").format(date)

                    val checkItems = planMap[todayKey]

                    val checkItemTitles = mutableListOf<String>()
                    checkItems?.forEach { checkItem->
                        if(checkItems.filter { it.book == checkItem.book }.size>=2){
                            checkItemTitles.add("${checkItem.book.toShortBible()}${checkItem.chapter}:${checkItem.verses.first().verse}~${checkItem.verses.last().verse}")
                        }
                        else{
                            checkItemTitles.add(checkItem.book.toShortBible())
                        }
                    }

                    Log.d(TAG, todayKey)

                    val fragmentList = mutableListOf<Fragment>()
                    checkItems?.forEach {
                        fragmentList.add(MccheyneSingleFragment(it))
                    }
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

                } else {
                    Log.e("tag", "json 파싱 실패")
                }
            }
        }
    }
}
