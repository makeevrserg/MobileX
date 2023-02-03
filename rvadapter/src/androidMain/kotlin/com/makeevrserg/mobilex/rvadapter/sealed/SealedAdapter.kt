package com.makeevrserg.mobilex.rvadapter.sealed

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.makeevrserg.mobilex.rvadapter.DefaultViewHolder
import com.makeevrserg.mobilex.rvadapter.UniqueViewHolder


class SealedAdapter<T : Any>(
    diffUtil: DiffUtil.ItemCallback<T>,
    vararg viewHolders: SealedViewHolder<*, *, *>
) : ListAdapter<T, RecyclerView.ViewHolder>(diffUtil) {

    private val viewHolders = viewHolders.toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val sealedViewHolder = viewHolders.firstOrNull() {
            it.viewType == viewType
        } ?: throw ClassCastException("Unknown viewType ${viewType}")
        val binding = sealedViewHolder.inflate(parent, viewType)
        val viewHolder = sealedViewHolder as UniqueViewHolder<*, ViewBinding>
        return DefaultViewHolder(binding, viewHolder)
    }


    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)!!
        return viewHolders.firstOrNull {
            it.clazz.name == item::class.java.name
        }?.viewType ?: throw ClassCastException("Unknown viewType")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position) ?: return
        (holder as? DefaultViewHolder<T, *>)?.bind(item)
    }
}