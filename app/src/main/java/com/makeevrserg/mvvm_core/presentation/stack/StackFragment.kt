package com.makeevrserg.mvvm_core.presentation.stack

import com.makeevrserg.mvvm_core.databinding.FragmentStackBinding
import com.makeevrserg.mvvm_core.lazyIntentManager
import com.makeevrserg.mvvm_core.presentation.main.MainViewModel
import com.makeevrserg.mvvmcore.core.lazyViewModel
import com.makeevrserg.mvvmcore.core.presentation.CoreBindingFragment
import com.makeevrserg.mvvmcore.core.presentation.intent_manager.IIntentManager

class StackFragment :
    CoreBindingFragment<FragmentStackBinding, StackViewModel>(FragmentStackBinding::inflate) {
    override val viewModel: StackViewModel by lazyViewModel()

    override val intentManager: IIntentManager<StackViewModel> by lazyIntentManager()

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