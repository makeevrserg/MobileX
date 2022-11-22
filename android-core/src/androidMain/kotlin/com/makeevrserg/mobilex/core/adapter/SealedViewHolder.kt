package com.makeevrserg.mobilex.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

fun <B : ViewBinding, T, V : T> sealedViewHolder(
    inflater: (LayoutInflater, ViewGroup, Boolean) -> B,
    clazz: Class<V>,
    viewType: Int,
    onBind: (binding: B, item: V) -> Unit
) = object : SealedViewHolder<B, T, V> {
    override val inflater: (LayoutInflater, ViewGroup, Boolean) -> B = inflater
    override val clazz: Class<V> = clazz
    override val viewType: Int = viewType
    override fun onBind(binding: B, item: V) {
        onBind(binding, item)
    }
}

interface SealedViewHolder<B : ViewBinding, T, V : T> {
    val inflater: (LayoutInflater, ViewGroup, Boolean) -> B
    val clazz: Class<V>
    val viewType: Int

    abstract fun onBind(binding: B, item: V)
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