package com.makeevrserg.mobilex.presentation.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.makeevrserg.mobilex.databinding.ExampleHeaderBinding
import com.makeevrserg.mobilex.presentation.list.ExampleList
import com.makeevrserg.mobilex.core.adapter.SealedViewHolder
import com.makeevrserg.mobilex.core.adapter.sealedViewHolder

val ExampleHeaderViewHolder = sealedViewHolder(
    ExampleHeaderBinding::inflate,
    ExampleList.Header::class.java,
    0,
    onBind = { binding, item ->
        binding.tv.text = item.message
    }
)