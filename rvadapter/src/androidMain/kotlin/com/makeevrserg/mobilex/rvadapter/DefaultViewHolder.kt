package com.makeevrserg.mobilex.rvadapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class DefaultViewHolder<T : Any, V : ViewBinding>(
    val binding: V,
    val sharedViewHolder: UniqueViewBinder<T, V>
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: T) {
        sharedViewHolder.bind(binding, item)
    }
}
