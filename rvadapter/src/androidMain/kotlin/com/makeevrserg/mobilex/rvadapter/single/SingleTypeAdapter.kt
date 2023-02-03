package com.makeevrserg.mobilex.rvadapter.single

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.makeevrserg.mobilex.rvadapter.DefaultViewHolder

class SingleTypeAdapter<T : Any, V : ViewBinding>(
    private val binder: SharedViewHolder<T, V>
) : ListAdapter<T, DefaultViewHolder<T, V>>(binder) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefaultViewHolder<T, V> {
        val binding = binder.inflate(parent, viewType)
        return DefaultViewHolder(binding, binder)
    }

    override fun onBindViewHolder(holder: DefaultViewHolder<T,V>, position: Int) {
        getItem(position)?.let(holder::bind)
    }
}
