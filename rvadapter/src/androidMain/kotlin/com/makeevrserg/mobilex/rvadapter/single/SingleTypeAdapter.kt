package com.makeevrserg.mobilex.rvadapter.single

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.makeevrserg.mobilex.rvadapter.DefaultViewHolder

class SingleTypeAdapter<T : Any, V : ViewBinding>(
    private val viewBinder: DefaultViewBinder<T, V>
) : ListAdapter<T, DefaultViewHolder<T, V>>(viewBinder) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefaultViewHolder<T, V> {
        val binding = viewBinder.inflate(parent, viewType)
        return DefaultViewHolder(binding, viewBinder)
    }

    override fun onBindViewHolder(holder: DefaultViewHolder<T,V>, position: Int) {
        getItem(position)?.let(holder::bind)
    }
}
