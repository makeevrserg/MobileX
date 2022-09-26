package com.makeevrserg.mvvm_core.presentation.main

import com.makeevrserg.mvvm_core.databinding.FragmentMainBinding
import com.makeevrserg.mvvmcore.core.lazyViewModel


class MainFragment :
    BindingFragment<FragmentMainBinding, MainViewModel>(FragmentMainBinding::inflate) {


    override val viewModel: MainViewModel by lazyViewModel()

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
        binding.bListFragment.setOnClickListener {
            viewModel.onListOpenClicked()

        }
    }
}


