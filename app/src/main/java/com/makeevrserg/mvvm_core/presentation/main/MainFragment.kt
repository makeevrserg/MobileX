package com.makeevrserg.mvvm_core.presentation.main

import android.app.Dialog
import android.content.Context
import android.view.View
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.makeevrserg.mvvm_core.databinding.FragmentMainBinding
import com.makeevrserg.mvvm_core.main.CiceroneNavigationProvider
import com.makeevrserg.mvvmcore.core.ui.UIDialogMessage
import com.makeevrserg.mvvmcore.core.lazyViewModel
import com.makeevrserg.mvvmcore.core.presentation.BindingFragment
import com.makeevrserg.mvvm_core.CoreAlertUiDialog
import com.makeevrserg.mvvm_core.CoreProgressDialog
import com.makeevrserg.mvvm_core.modules.RouterModule
import com.makeevrserg.mvvmcore.core.routing.IRouter
import com.makeevrserg.mvvmcore.core.ui.dialog.IUiDialogListener
import com.makeevrserg.mvvmcore.core.ui.loading.IUiLoadingListener
import com.makeevrserg.mvvmcore.core.ui.message.IUiMessageListener
import com.makeevrserg.mvvmcore.core.ui.route.IUiRouteListener



class MainFragment :
    BindingFragment<FragmentMainBinding>(FragmentMainBinding::inflate),
    IUiRouteListener<FragmentScreen>, IUiDialogListener, IUiLoadingListener, IUiMessageListener {

    private val viewModel: MainViewModel by lazyViewModel()
    override val rootProvider: () -> View? = { binding?.root }
    override val contextProvider: () -> Context? = { context }
    override var currentDialog: Dialog? = null
    override val dialogBuilder: (UIDialogMessage) -> Dialog? = block@{
        val context = context ?: return@block null
        CoreAlertUiDialog.build(context, it)
    }

    override var currentLoadingDialog: Dialog? = null
    override val loadingDialogBuilder: () -> Dialog? = block@{
        val context = context ?: return@block null
        CoreProgressDialog.build(context)
    }
    override val navigationProvider: IRouter<FragmentScreen> =
        CiceroneNavigationProvider(RouterModule.value)

    override fun onBinding(binding: FragmentMainBinding) {
        super.onBinding(binding)
        collectUiMessage(this, viewModel)
        collectUiDialog(this, viewModel)
        collectUiLoading(this, viewModel)
        collectUiRoute(this, viewModel)
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
        binding.bComposeActivity.setOnClickListener {
            viewModel.onComposeActivityClicked()
        }
    }

}


