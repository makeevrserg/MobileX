package com.makeevrserg.mobilex.presentation.stack

import android.content.Context
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.makeevrserg.mobilex.databinding.FragmentStackBinding
import com.makeevrserg.mobilex.main.CiceroneNavigationProvider
import com.makeevrserg.mobilex.modules.RouterModule
import com.makeevrserg.mobilex.core.lazyViewModel
import com.makeevrserg.mobilex.core.presentation.BindingFragment
import com.makeevrserg.mobilex.core.routing.IRouter
import com.makeevrserg.mobilex.core.ui.route.IUiRouteListener

class StackFragment :
    BindingFragment<FragmentStackBinding>(FragmentStackBinding::inflate),
    IUiRouteListener<FragmentScreen> {
    val viewModel: StackViewModel by lazyViewModel()
    override val contextProvider: () -> Context? = { context }
    override val navigationProvider: IRouter<FragmentScreen> =
        CiceroneNavigationProvider(RouterModule.value)

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