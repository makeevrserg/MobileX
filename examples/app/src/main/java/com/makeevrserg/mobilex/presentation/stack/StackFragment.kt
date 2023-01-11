package com.makeevrserg.mobilex.presentation.stack

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.makeevrserg.mobilex.R
import com.makeevrserg.mobilex.actions.CiceroneListener
import com.makeevrserg.mobilex.ktx_core.binding.viewBinding
import com.makeevrserg.mobilex.databinding.FragmentStackBinding
import com.makeevrserg.mobilex.defaultFragmentViewProvider
import com.makeevrserg.mobilex.modules.RouterModule

class StackFragment : Fragment(R.layout.fragment_stack){
    val viewModel: StackViewModel by lazy { StackViewModel() }

    private val fragmentViewProvider = defaultFragmentViewProvider()
    private val binding by viewBinding(R.layout.fragment_stack,FragmentStackBinding::bind)
    private val ciceroneListener = CiceroneListener(RouterModule.value,lifecycleScope,fragmentViewProvider)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ciceroneListener.collect(viewModel.actionContainer)
        with(binding){
            binding.tv.text = viewModel.count.toString()
            binding.bNewScreen.setOnClickListener {
                viewModel.onNewScreenClicked()
            }
            binding.bClearBackStack.setOnClickListener {
                viewModel.onClearBackStackClicked()
            }
            binding.bIntent.setOnClickListener {
                viewModel.onIntentClicked()
            }
            binding.bPopBack.setOnClickListener {
                viewModel.onPopBackClicked()
            }
            binding.bReplaceScreen.setOnClickListener {
                viewModel.onReplaceScreenClicked()
            }
        }
    }
    override fun onDestroy() {
        viewModel.onViewDestroy()
        super.onDestroy()
    }
}