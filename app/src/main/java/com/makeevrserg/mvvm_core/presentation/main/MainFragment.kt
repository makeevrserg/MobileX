package com.makeevrserg.mvvm_core.presentation.main

import com.makeevrserg.mvvm_core.databinding.FragmentMainBinding
import com.makeevrserg.mvvm_core.lazyIntentManager
import com.makeevrserg.mvvmcore.core.lazyViewModel
import com.makeevrserg.mvvmcore.core.presentation.CoreBindingFragment
import com.makeevrserg.mvvmcore.core.presentation.intent_manager.IIntentManager


class MainFragment :
    CoreBindingFragment<FragmentMainBinding, MainViewModel>(FragmentMainBinding::inflate) {
    override val viewModel: MainViewModel by lazyViewModel()

    override val intentManager: IIntentManager<MainViewModel> by lazyIntentManager()

    override fun onBinding(binding: FragmentMainBinding) {
        super.onBinding(binding)
        binding.bShowDialog.setOnClickListener {
            viewModel.onShowDialogClicked()
        }
        binding.bShowLoading.setOnClickListener {
            viewModel.onShowLoadingClicked()

        }
        binding.bShowSnackBar.setOnClickListener {
            viewModel.onShoSnackbarClicked()

        }
        binding.bShowToast.setOnClickListener {
            viewModel.onShowToastClicked()

        }
        binding.bNavigation.setOnClickListener {
            viewModel.onBasicNavigationClicked()

        }
    }
}


