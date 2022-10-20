package com.makeevrserg.mvvm_core.presentation.list

import com.makeevrserg.mvvm_core.databinding.FragmentListBinding
import com.makeevrserg.mvvm_core.presentation.list.adapter.ExampleAdapter
import com.makeevrserg.mvvmcore.core.lazyViewModel
import com.makeevrserg.mvvmcore.core.presentation.BindingFragment
import com.makeevrserg.mvvmcore.core.randomization.Randomization

class ListFragment :
    BindingFragment<FragmentListBinding>(FragmentListBinding::inflate) {
    val viewModel: ListViewModel by lazyViewModel()
    private val adapter by lazy { ExampleAdapter() }

    private val list = Randomization.ofList(1000) {
        Randomization.ExampleListItem
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

val Randomization.ExampleListItem: ExampleList.Item
    get() = ExampleList.Item()
val Randomization.ExampleListHeader: ExampleList.Header
    get() = ExampleList.Header()
