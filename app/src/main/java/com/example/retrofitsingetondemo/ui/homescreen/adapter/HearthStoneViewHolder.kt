package com.example.retrofitsingetondemo.ui.homescreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitsingetondemo.R

class HearthStoneViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(
    inflater.inflate(
        R.layout.item_hearthstone_classes_viewholder, parent, false
    )
) {
    private val className: TextView = itemView.findViewById(R.id.class_name)
    fun bind(classDataWrapper: String?) {
        className.text = classDataWrapper
    }

}
