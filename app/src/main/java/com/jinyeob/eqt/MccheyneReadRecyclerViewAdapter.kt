package com.jinyeob.eqt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MccheyneReadRecyclerViewAdapter(private val plan: Map<String, List<CheckItem>>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return viewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.outer_mccheyne_read_recyclerview_content, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val date = plan.keys.elementAt(position)
        plan[date]?.let { (holder as viewHolder).bind(date, it) }
    }

    override fun getItemCount(): Int {
        return plan.size
    }

    inner class viewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val dateTextView = view.findViewById<TextView>(R.id.date_textview)
        val innerRecyclerView = view.findViewById<RecyclerView>(R.id.inner_recyclerview)
        fun bind(date: String, checkItems: List<CheckItem>) {
            dateTextView.text = date

        }
    }
}
