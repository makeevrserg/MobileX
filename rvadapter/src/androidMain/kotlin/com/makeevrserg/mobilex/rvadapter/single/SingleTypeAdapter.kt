package com.makeevrserg.mobilex.rvadapter.single

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class SingleTypeAdapter<T : Any, V : ViewBinding>(private val binder: AdapterBinder<T, V>) :
    ListAdapter<T, SingleTypeAdapter<T, V>.ViewHolder>(binder.generateDiffCallback()) {

    inner class ViewHolder(val binding: V) : RecyclerView.ViewHolder(binding.root) {
        fun bind(operation: T) {
            binder.bind(binding, operation)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = binder.inflater(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let(holder::bind)
    }
}
