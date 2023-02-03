package com.makeevrserg.mobilex.rvadapter.single

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.viewbinding.ViewBinding
import com.makeevrserg.mobilex.rvadapter.UniqueViewBinder

abstract class DefaultViewBinder<T : Any, V : ViewBinding>(
    val inflater: (layoutInflater: LayoutInflater, viewGroup: ViewGroup, attachToParent: Boolean) -> V
) : UniqueViewBinder<T, V>, DiffUtil.ItemCallback<T>() {
    override fun inflate(parent: ViewGroup, viewType: Int): V {
        val layoutInflater = LayoutInflater.from(parent.context)
        return inflater(layoutInflater, parent, false)
    }

    /**
     * ViewType of adapter - no need to change for one-type adapter
     */
    override val viewType: Int = 0

    fun asAdapter(): SingleTypeAdapter<T, V> = SingleTypeAdapter(this)
}