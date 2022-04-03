package com.jinyeob.eqt

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.tabs.TabLayoutMediator
import com.jinyeob.domain.model.CheckItem
import com.jinyeob.domain.model.MccheyneItem
import com.jinyeob.eqt.ExtensionMethods.toShortBible
import com.jinyeob.eqt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
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

        binding.viewModel = viewModel

        lifecycleScope.launch {
            viewModel.mccheyneFlow.collect {
                viewModel.mccheyneItem = it
                viewModel.currentSelectedDate.set(Date(System.currentTimeMillis()))
                setViews(
                    it,
                    SimpleDateFormat(DATE_FORMAT).format(viewModel.currentSelectedDate.get()!!)
                )
            }
        }

        binding.dateButton.setOnClickListener(dateClickListener())
    }

    @SuppressLint("SimpleDateFormat")
    private fun dateClickListener() = View.OnClickListener {
        val calendar = Calendar.getInstance()
        val prevDate = Calendar.getInstance()
        prevDate.time = viewModel.currentSelectedDate.get()!!

        DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                viewModel.currentSelectedDate.set(calendar.time)
                setViews(
                    viewModel.mccheyneItem,
                    SimpleDateFormat(DATE_FORMAT).format(calendar.time)
                )
            },
            prevDate.get(Calendar.YEAR),
            prevDate.get(Calendar.MONTH),
            prevDate.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun setViews(mccheyneItem: MccheyneItem, dayKey: String) {
        if (mccheyneItem.plan.isEmpty()) return

        val checkItems = mccheyneItem.plan[dayKey]

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

    companion object {
        const val DATE_FORMAT = "M-d"
    }
}
