package com.makeevrserg.mvvmcore.core.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.makeevrserg.mvvmcore.core.collectOn
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.listeners.ILoadingIndicatorListener
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.listeners.INextRouteListener
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.listeners.IUiDialogListener
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.listeners.IUiMessageListener
import kotlinx.coroutines.Dispatchers

/**
 * Во многих экранах используется android sythetic, который уже давно устарел
 * Этот класс позволяет довольно легко создавать MVVM экраны с ViewBinding'ом и содержит вроде бы всё, что может пригодиться
 * Наследуется от [BaseFragment] - проект очень сильно завязан на MVP, сложно уйти от этого
 */
abstract class CoreBindingFragment<T : ViewBinding, V : CoreViewModel>(private val bindingFactory: (LayoutInflater) -> T) :
    Fragment() {

    protected var binding: T? = null

    abstract val uiMessageListener: IUiMessageListener
    abstract val uiDialogListener: IUiDialogListener
    abstract val nextRouteListener: INextRouteListener
    abstract val loadingIndicatorListener: ILoadingIndicatorListener

    abstract val viewModel: V

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
            it?.let(uiDialogListener::onUiDialog)
        }
    }

    protected open fun collectUiMessage() {
        viewModel.uiMessage.collectOn(this, Dispatchers.Main) {
            val binding = binding ?: return@collectOn
            it.value?.let {
                uiMessageListener.onUiMessage(binding.root, it)
            }
        }
    }

    protected open fun collectLoadingIndicator() {
        viewModel.loadingIndicator.collectOn(this, Dispatchers.Main) {
            loadingIndicatorListener.onLoadingIndication(it)
        }
    }

    protected open fun collectRouteAction() {
        viewModel.routeAction.collectOn(this, Dispatchers.Main) {
//            it.value?.let(intentManager::onRouteAction)
        }
    }

    protected open fun collectNextRoute() {
        viewModel.nextRoute.collectOn(this, Dispatchers.Main) {
            it.value?.let(nextRouteListener::onRouteInfo)
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