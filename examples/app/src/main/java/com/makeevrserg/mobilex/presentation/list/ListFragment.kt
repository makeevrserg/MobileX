package com.makeevrserg.mobilex.presentation.list

import com.makeevrserg.mobilex.databinding.FragmentListBinding
import com.makeevrserg.mobilex.presentation.list.adapter.ExampleAdapter
import com.makeevrserg.mobilex.core.lazyViewModel
import com.makeevrserg.mobilex.core.presentation.BindingFragment

class ListFragment :
    BindingFragment<FragmentListBinding>(FragmentListBinding::inflate) {
    val viewModel: ListViewModel by lazyViewModel()
    private val adapter by lazy { ExampleAdapter() }

    private val list = com.makeevrserg.mobilex.ktx_core.Randomization.ofList(1000) {
        ExampleListItem
    }.groupBy { it.groupItem }.flatMap { (group, list) ->
        buildList<ExampleList> {
            add(ExampleList.Header(message = "${list.size} items"))
            addAll(list)
        }

    }

    override fun onBinding(binding: FragmentListBinding) {
        super.onBinding(binding)

        binding.rv.adapter = adapter
        adapter.submitList(list)

    }
}

val ExampleListItem: ExampleList.Item
    get() = ExampleList.Item()
val ExampleListHeader: ExampleList.Header
    get() = ExampleList.Header()
