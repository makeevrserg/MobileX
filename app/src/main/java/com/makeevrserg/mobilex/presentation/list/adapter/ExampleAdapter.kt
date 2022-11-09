package com.makeevrserg.mobilex.presentation.list.adapter

import com.makeevrserg.mobilex.presentation.list.ExampleList
import com.makeevrserg.mobilex.core.adapter.IEasyAdapter


class ExampleAdapter : IEasyAdapter<ExampleList, Int, ExampleList>(
    ExampleHeaderViewHolder(),
    ExampleItemViewHolder()
)