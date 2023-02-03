package com.makeevrserg.mobilex.rvadapter.sealed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.makeevrserg.mobilex.rvadapter.UniqueViewHolder

abstract class SealedViewHolder<T : Any, K : T, V : ViewBinding>(
    val clazz: Class<K>,
    val inflater: (layoutInflater: LayoutInflater, viewGroup: ViewGroup, attachToParent: Boolean) -> V
) : UniqueViewHolder<K, V> {
    override fun inflate(parent: ViewGroup, viewType: Int): V {
        val layoutInflater = LayoutInflater.from(parent.context)
        return inflater(layoutInflater, parent, false)
    }
}