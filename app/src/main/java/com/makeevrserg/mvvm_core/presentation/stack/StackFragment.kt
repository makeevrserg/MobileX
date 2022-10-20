package com.makeevrserg.mvvm_core.presentation.stack

import android.content.Context
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.makeevrserg.mvvm_core.databinding.FragmentStackBinding
import com.makeevrserg.mvvm_core.main.App
import com.makeevrserg.mvvm_core.main.CiceroneNavigationProvider
import com.makeevrserg.mvvmcore.core.lazyViewModel
import com.makeevrserg.mvvmcore.core.presentation.BindingFragment
import com.makeevrserg.mvvmcore.core.routing.INavigationProvider
import com.makeevrserg.mvvmcore.core.ui.route.IUiRouteListener

class StackFragment :
    BindingFragment<FragmentStackBinding>(FragmentStackBinding::inflate),
    IUiRouteListener<FragmentScreen> {
    val viewModel: StackViewModel by lazyViewModel()
    override val contextProvider: () -> Context? = { context }
    override val navigationProvider: INavigationProvider<FragmentScreen> =
        CiceroneNavigationProvider(App.router)

    override fun onBinding(binding: FragmentStackBinding) {
        super.onBinding(binding)
        collectUiRoute(this, viewModel)
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