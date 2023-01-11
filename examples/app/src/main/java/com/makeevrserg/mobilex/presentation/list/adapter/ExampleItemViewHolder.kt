package com.makeevrserg.mobilex.presentation.list.adapter

import com.makeevrserg.mobilex.databinding.ExampleItemBinding
import com.makeevrserg.mobilex.presentation.list.ExampleList
import com.makeevrserg.mobilex.rvadapter.sealedViewHolder

val ExampleItemViewHolder = sealedViewHolder(
    ExampleItemBinding::inflate,
    ExampleList.Item::class.java,
    1,
    onBind = { binding, item ->
        binding.tvDescription.text = item.description
        binding.tvTitle.text = item.title
    }
)