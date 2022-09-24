package com.makeevrserg.mvvm_core.presentation.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.makeevrserg.mvvm_core.databinding.ExampleHeaderBinding
import com.makeevrserg.mvvm_core.presentation.list.ExampleList
import com.makeevrserg.mvvmcore.core.adapter.SealedViewHolder

class ExampleHeaderViewHolder :
    SealedViewHolder<ExampleHeaderBinding, ExampleList, ExampleList.Header>() {
    override val inflater: (LayoutInflater, ViewGroup, Boolean) -> ExampleHeaderBinding =
        ExampleHeaderBinding::inflate

    override fun onBind(binding: ExampleHeaderBinding, item: ExampleList.Header) {
        binding.tv.text = item.message
    }

    override val clazz: Class<ExampleList.Header> = ExampleList.Header::class.java
    override val viewType: Int
        get() = 0

}