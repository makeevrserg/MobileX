package com.makeevrserg.mobilex.rvadapter

import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

interface UniqueViewBinder<T : Any, V : ViewBinding> {
    val viewType: Int
    fun bind(binding: V, item: T)
    fun inflate(parent: ViewGroup, viewType: Int): V
}