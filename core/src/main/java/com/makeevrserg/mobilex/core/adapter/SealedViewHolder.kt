package com.makeevrserg.mobilex.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BasicViewHolder<B : ViewBinding, T>(override val inflater: (LayoutInflater, ViewGroup, Boolean) -> B) :
    SealedViewHolder<B, T, T>()

abstract class SealedViewHolder<B : ViewBinding, T, V : T> {
    abstract val inflater: (LayoutInflater, ViewGroup, Boolean) -> B
    abstract fun onBind(binding: B, item: V)
    abstract val clazz: Class<V>
    abstract val viewType: Int
    fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = createBinding(parent, this)

}

interface UniqueViewHolder<T> {
    val viewType: Int
    fun bind(item: T)
}

private fun <B : ViewBinding, T, V : T> createBinding(
    parent: ViewGroup,
    basicViewHolder: SealedViewHolder<B, T, V>
): RecyclerView.ViewHolder {
    val layoutInflater = LayoutInflater.from(parent.context)
    val inflater = basicViewHolder.inflater(layoutInflater, parent, false)
    return object : RecyclerView.ViewHolder(inflater.root), UniqueViewHolder<V> {
        override val viewType: Int = basicViewHolder.viewType
        override fun bind(item: V) = basicViewHolder.onBind(inflater, item)
    }
}