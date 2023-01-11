package com.makeevrserg.mobilex.rvadapter.single

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.viewbinding.ViewBinding

abstract class AdapterBinder<T : Any, V : ViewBinding>(
    val inflater: (layoutInflater: LayoutInflater, viewGroup: ViewGroup, attachToParent: Boolean) -> V
) {
    abstract fun bind(binding: V, item: T)
    abstract fun areItemsTheSame(oldItem: T, newItem: T): Boolean
    abstract fun areContentsTheSame(oldItem: T, newItem: T): Boolean
    fun generateDiffCallback() = object : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(
            oldItem: T,
            newItem: T
        ): Boolean = this@AdapterBinder.areItemsTheSame(oldItem, newItem)

        override fun areContentsTheSame(
            oldItem: T,
            newItem: T
        ): Boolean = this@AdapterBinder.areContentsTheSame(oldItem, newItem)
    }

    fun asAdapter(): SingleTypeAdapter<T, V> = SingleTypeAdapter(this)
}