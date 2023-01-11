package com.makeevrserg.mobilex.rvadapter

import androidx.recyclerview.widget.DiffUtil

interface IDiffItem<T, K> {
    val id: T
    val instance: K
    fun isEquals(newItem: IDiffItem<T, K>): Boolean
}

fun <T : IDiffItem<V, K>, V, K> generateDiffCallback(): DiffUtil.ItemCallback<T> =
    object : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem.isEquals(newItem)
        }
    }