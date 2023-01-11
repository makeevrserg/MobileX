package com.makeevrserg.mobilex.presentation.list.adapter

import com.makeevrserg.mobilex.databinding.ExampleHeaderBinding
import com.makeevrserg.mobilex.presentation.list.ExampleList
import com.makeevrserg.mobilex.rvadapter.sealedViewHolder

val ExampleHeaderViewHolder = sealedViewHolder(
    ExampleHeaderBinding::inflate,
    ExampleList.Header::class.java,
    0,
    onBind = { binding, item ->
        binding.tv.text = item.message
    }
)