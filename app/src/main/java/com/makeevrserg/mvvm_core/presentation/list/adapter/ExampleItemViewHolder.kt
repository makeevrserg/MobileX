package com.makeevrserg.mvvm_core.presentation.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.makeevrserg.mvvm_core.databinding.ExampleItemBinding
import com.makeevrserg.mvvm_core.presentation.list.ExampleList
import com.makeevrserg.mvvmcore.core.adapter.SealedViewHolder

class ExampleItemViewHolder :
    SealedViewHolder<ExampleItemBinding, ExampleList, ExampleList.Item>() {
    override val inflater: (LayoutInflater, ViewGroup, Boolean) -> ExampleItemBinding =
        ExampleItemBinding::inflate

    override fun onBind(binding: ExampleItemBinding, item: ExampleList.Item) {
        binding.tvDescription.text = item.description
        binding.tvTitle.text = item.title
    }

    override val clazz: Class<ExampleList.Item> = ExampleList.Item::class.java
    override val viewType: Int
        get() = 1

}