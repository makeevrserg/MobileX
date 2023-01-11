package com.makeevrserg.mobilex.presentation.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.makeevrserg.mobilex.R
import com.makeevrserg.mobilex.ktx_core.binding.viewBinding
import com.makeevrserg.mobilex.databinding.FragmentListBinding
import com.makeevrserg.mobilex.presentation.list.adapter.ExampleAdapter

class ListFragment : Fragment(R.layout.fragment_list) {
    val viewModel: ListViewModel by lazy { ListViewModel() }
    private val adapter by lazy { ExampleAdapter() }

    private val list = com.makeevrserg.mobilex.ktx_core.Randomization.ofList(1000) {
        ExampleListItem
    }.groupBy { it.groupItem }.flatMap { (group, list) ->
        buildList<ExampleList> {
            add(ExampleList.Header(message = "${list.size} items"))
            addAll(list)
        }

    }
    private val binding by viewBinding(R.layout.fragment_list, FragmentListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            binding.rv.adapter = adapter
            adapter.submitList(list)
        }
    }
}

val ExampleListItem: ExampleList.Item
    get() = ExampleList.Item()
val ExampleListHeader: ExampleList.Header
    get() = ExampleList.Header()
