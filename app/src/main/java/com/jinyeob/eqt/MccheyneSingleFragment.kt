package com.jinyeob.eqt

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.jinyeob.domain.model.CheckItem
import com.jinyeob.domain.model.VerseItem
import com.jinyeob.eqt.MyApplication.Companion.TAG
import com.jinyeob.eqt.databinding.FragmentMccheyneSingleBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MccheyneSingleFragment(private val checkItem: CheckItem) : Fragment() {
    private var binding by autoCleared<FragmentMccheyneSingleBinding>()

    @Inject
    lateinit var recyclerViewAdapter: MccheyneSingleRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMccheyneSingleBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewAdapter.setOnItemChangedListener(object :
            MccheyneSingleRecyclerViewAdapter.OnItemListener {
            override fun onItemClick(view: View, item: VerseItem, position: Int) {
                Log.d(TAG, "onItemClick: ${item.content}")
            }
        })
        with(binding) {
            singleMccheyneReadTitle.text = "${checkItem.book}${checkItem.chapter}장"

            singleMccheyneReadRecyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = recyclerViewAdapter
            }
        }

        recyclerViewAdapter.submitList(checkItem.verses)
    }
}
