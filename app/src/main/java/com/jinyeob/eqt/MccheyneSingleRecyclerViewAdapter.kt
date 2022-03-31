package com.jinyeob.eqt

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jinyeob.domain.model.VerseItem
import com.jinyeob.eqt.databinding.MccheyneSingleRecyclerviewContentBinding
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@FragmentScoped
class MccheyneSingleRecyclerViewAdapter @Inject constructor() :
    ListAdapter<VerseItem, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            MccheyneSingleRecyclerviewContentBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.bind(getItem(position) as VerseItem)
        }
    }

    inner class ViewHolder(private val binding: MccheyneSingleRecyclerviewContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: VerseItem) {
            binding.mccheyneSingleContentTextview.text = "${item.verse} ${item.content}"

            val pos = bindingAdapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                itemView.setOnClickListener {
                    itemListener.onItemClick(itemView, item, pos)
                }
            }
        }
    }

    interface OnItemListener {
        fun onItemClick(view: View, item: VerseItem, position: Int)
    }

    private lateinit var itemListener: OnItemListener

    fun setOnItemChangedListener(listener: OnItemListener) {
        this.itemListener = listener
    }

    class DiffCallback : DiffUtil.ItemCallback<VerseItem>() {
        override fun areContentsTheSame(
            oldItem: VerseItem,
            newItem: VerseItem
        ) = oldItem == newItem

        override fun areItemsTheSame(
            oldItem: VerseItem,
            newItem: VerseItem
        ) = oldItem == newItem
    }
}
