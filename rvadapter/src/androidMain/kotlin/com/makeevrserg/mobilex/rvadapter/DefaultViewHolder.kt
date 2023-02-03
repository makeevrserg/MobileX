package com.makeevrserg.mobilex.rvadapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.makeevrserg.mobilex.rvadapter.single.SharedViewHolder

class DefaultViewHolder<T : Any, V : ViewBinding>(
    val binding: V,
    val sharedViewHolder: UniqueViewHolder<T, V>
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: T) {
        sharedViewHolder.bind(binding, item)
    }
}
