package com.makeevrserg.mobilex.presentation.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.makeevrserg.mobilex.R
import com.makeevrserg.mobilex.databinding.FragmentListBinding
import com.makeevrserg.mobilex.presentation.list.adapters.SingleUserItemViewHolder
import com.makeevrserg.mobilex.presentation.list.adapters.sealed.SealedDiffCallback
import com.makeevrserg.mobilex.presentation.list.adapters.sealed.UserHeaderViewHolder
import com.makeevrserg.mobilex.presentation.list.adapters.sealed.UserItemViewHolder
import com.makeevrserg.mobilex.rvadapter.sealed.SealedAdapter

class ListFragment : Fragment(R.layout.fragment_list) {
    val viewModel: ListViewModel by lazy { ListViewModel() }
    private val singleTypeAdapter by lazy { SingleUserItemViewHolder().asAdapter() }
    private val binding by viewBinding(FragmentListBinding::bind)
    private val multiTypeAdapter by lazy {
        SealedAdapter(
            SealedDiffCallback,
            UserHeaderViewHolder(),
            UserItemViewHolder()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            setDefault(rv)
            bChange.setOnClickListener {
                if (rv.adapter ==multiTypeAdapter)
                    setDefault(rv)
                else setSealed(rv)
            }
        }
    }

    private fun setSealed(recyclerView: RecyclerView) {
        recyclerView.adapter = multiTypeAdapter
        multiTypeAdapter.submitList(viewModel.sealedList)
    }

    private fun setDefault(recyclerView: RecyclerView) {
        recyclerView.adapter = singleTypeAdapter
        singleTypeAdapter.submitList(viewModel.list)
    }
}


