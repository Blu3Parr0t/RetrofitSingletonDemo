package com.example.retrofitsingetondemo.ui.homescreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

internal class ClassesAdapter : RecyclerView.Adapter<HearthStoneViewHolder>() {
    private var hearthStoneClasses: List<String?>? = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HearthStoneViewHolder {
        return HearthStoneViewHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: HearthStoneViewHolder, position: Int) {
        holder.bind(hearthStoneClasses?.get(position))
    }

    override fun getItemCount(): Int {
        return hearthStoneClasses?.size ?: 0
    }

    fun setData(newClassesList: List<String?>?) {
        this.hearthStoneClasses = newClassesList
        notifyDataSetChanged()
    }
}
