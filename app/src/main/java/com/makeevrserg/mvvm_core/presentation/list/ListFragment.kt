package com.makeevrserg.mvvm_core.presentation.list

import com.makeevrserg.mvvm_core.databinding.FragmentListBinding
import com.makeevrserg.mvvm_core.lazyIntentManager
import com.makeevrserg.mvvm_core.presentation.list.adapter.ExampleAdapter
import com.makeevrserg.mvvmcore.core.adapter.IDiffItem
import com.makeevrserg.mvvmcore.core.lazyViewModel
import com.makeevrserg.mvvmcore.core.presentation.CoreBindingFragment
import com.makeevrserg.mvvmcore.core.presentation.intent_manager.IIntentManager
import com.makeevrserg.mvvmcore.core.randomization.Randomization
import com.makeevrserg.mvvmcore.core.randomization.Randomization.randomize

class ListFragment :
    CoreBindingFragment<FragmentListBinding, ListViewModel>(FragmentListBinding::inflate) {
    override val viewModel: ListViewModel by lazyViewModel()
    override val intentManager: IIntentManager<ListViewModel> by lazyIntentManager()
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
