package com.makeevrserg.mobilex.core.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class IEasyAdapter<T : IDiffItem<K, V>, K, V>(
    vararg viewHolders: SealedViewHolder<*, *, *>
) : ListAdapter<T, RecyclerView.ViewHolder>(generateDiffCallback()) {

    private val viewHolders = viewHolders.toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder = viewHolders.firstOrNull() {
            it.viewType == viewType
        }?.createViewHolder(parent)
        return viewHolder ?: throw ClassCastException("Unknown viewType ${viewType}")
    }


    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)!!
        return viewHolders.firstOrNull {
            it.clazz.name == item::class.java.name
        }?.viewType ?: throw ClassCastException("Unknown viewType")
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position) as T
        (holder as? UniqueViewHolder<T>)?.bind(item)
    }

}