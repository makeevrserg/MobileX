package com.makeevrserg.mobilex.rvadapter.single

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.makeevrserg.mobilex.rvadapter.DefaultViewHolder

class SingleTypeAdapter<T : Any, V : ViewBinding>(
    private val viewBinder: DefaultViewBinder<T, V>
) : ListAdapter<T, RecyclerView.ViewHolder>(viewBinder) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = viewBinder.inflate(parent, viewType)
        return DefaultViewHolder(binding, viewBinder)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val holder = holder as? DefaultViewHolder<T, V> ?: throw ClassCastException("holder should be DefaultViewHolder<T,V> How did you manage to change it?")
        getItem(position)?.let(holder::bind)
    }
}
