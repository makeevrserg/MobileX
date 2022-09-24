package com.makeevrserg.mvvm_core.presentation.list.adapter

import com.makeevrserg.mvvm_core.presentation.list.ExampleList
import com.makeevrserg.mvvmcore.core.adapter.IEasyAdapter


class ExampleAdapter : IEasyAdapter<ExampleList, Int, ExampleList>(
    ExampleHeaderViewHolder(),
    ExampleItemViewHolder()
)