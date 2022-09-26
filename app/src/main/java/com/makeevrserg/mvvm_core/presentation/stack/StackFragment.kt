package com.makeevrserg.mvvm_core.presentation.stack

import com.makeevrserg.mvvm_core.databinding.FragmentStackBinding
import com.makeevrserg.mvvm_core.presentation.main.BindingFragment
import com.makeevrserg.mvvmcore.core.lazyViewModel

class StackFragment :
    BindingFragment<FragmentStackBinding, StackViewModel>(FragmentStackBinding::inflate) {
    override val viewModel: StackViewModel by lazyViewModel()

    override fun onBinding(binding: FragmentStackBinding) {
        super.onBinding(binding)
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

    override fun onDestroy() {
        viewModel.onViewDestroy()
        super.onDestroy()
    }
}