package com.makeevrserg.mvvm_core.presentation.list

import com.makeevrserg.mvvm_core.databinding.FragmentListBinding
import com.makeevrserg.mvvm_core.presentation.list.adapter.ExampleAdapter
import com.makeevrserg.mvvmcore.core.lazyViewModel
import com.makeevrserg.mvvmcore.core.presentation.BindingFragment
import com.makeevrserg.mvvm_core.ktx_core.Randomization

class ListFragment :
    BindingFragment<FragmentListBinding>(FragmentListBinding::inflate) {
    val viewModel: ListViewModel by lazyViewModel()
    private val adapter by lazy { ExampleAdapter() }

    private val list = com.makeevrserg.mvvm_core.ktx_core.Randomization.ofList(1000) {
        com.makeevrserg.mvvm_core.ktx_core.Randomization.ExampleListItem
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

val com.makeevrserg.mvvm_core.ktx_core.Randomization.ExampleListItem: ExampleList.Item
    get() = ExampleList.Item()
val com.makeevrserg.mvvm_core.ktx_core.Randomization.ExampleListHeader: ExampleList.Header
    get() = ExampleList.Header()
