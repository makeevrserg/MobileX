package com.makeevrserg.mobilex.presentation.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.makeevrserg.mobilex.databinding.ExampleItemBinding
import com.makeevrserg.mobilex.presentation.list.ExampleList
import com.makeevrserg.mobilex.core.adapter.SealedViewHolder
import com.makeevrserg.mobilex.core.adapter.sealedViewHolder
import com.makeevrserg.mobilex.databinding.ExampleHeaderBinding

val ExampleItemViewHolder = sealedViewHolder(
    ExampleItemBinding::inflate,
    ExampleList.Item::class.java,
    1,
    onBind = { binding, item ->
        binding.tvDescription.text = item.description
        binding.tvTitle.text = item.title
    }
)