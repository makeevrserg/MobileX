package com.makeevrserg.mvvmcore.core.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.makeevrserg.mvvmcore.core.collectOn
import com.makeevrserg.mvvmcore.core.presentation.intent_manager.IIntentManager
import kotlinx.coroutines.Dispatchers

/**
 * Во многих экранах используется android sythetic, который уже давно устарел
 * Этот класс позволяет довольно легко создавать MVVM экраны с ViewBinding'ом и содержит вроде бы всё, что может пригодиться
 * Наследуется от [BaseFragment] - проект очень сильно завязан на MVP, сложно уйти от этого
 */
abstract class CoreBindingFragment<T : ViewBinding, V : CoreViewModel>(private val bindingFactory: (LayoutInflater) -> T) :
    Fragment() {

    protected var binding: T? = null

    abstract val viewModel: V

    protected abstract val intentManager: IIntentManager<V>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = bindingFactory(inflater).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.let(::onBinding)
    }

    protected open fun collectUiDialogMessage() {
        viewModel.uiDialogMessage.collectOn(this, Dispatchers.Main) {
            it?.let(intentManager::onUiDialogMessage)
        }
    }
    protected open fun collectUiMessage() {
        viewModel.uiMessage.collectOn(this, Dispatchers.Main) {
            val binding = binding ?: return@collectOn
            it.value?.let {
                intentManager.onUiMessage(binding.root,it)
            }
        }
    }

    protected open fun collectLoadingIndicator() {
        viewModel.loadingIndicator.collectOn(this, Dispatchers.Main) {
            intentManager.onLoadingIndicator(it)
        }
    }

    protected open fun collectRouteAction() {
        viewModel.routeAction.collectOn(this, Dispatchers.Main) {
            it.value?.let {
                intentManager.onRouteAction(it)
            }
        }
    }

    protected open fun collectNextRoute() {
        viewModel.nextRoute.collectOn(this, Dispatchers.Main) {
            it.value?.let {
                intentManager.onRouteInfo(it)
            }
        }
    }

    open fun onBinding(binding: T) {
        viewModel.onBinding()
        collectUiDialogMessage()
        collectUiMessage()
        collectLoadingIndicator()
        collectNextRoute()
        collectRouteAction()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}