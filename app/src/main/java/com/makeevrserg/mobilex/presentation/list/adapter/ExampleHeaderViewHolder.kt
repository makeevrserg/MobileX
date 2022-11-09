package com.makeevrserg.mobilex.presentation.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.makeevrserg.mobilex.databinding.ExampleHeaderBinding
import com.makeevrserg.mobilex.presentation.list.ExampleList
import com.makeevrserg.mobilex.core.adapter.SealedViewHolder

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