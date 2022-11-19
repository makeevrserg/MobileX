package com.makeevrserg.mobilex.presentation.main

import android.app.Dialog
import android.content.Context
import android.view.View
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.makeevrserg.mobilex.databinding.FragmentMainBinding
import com.makeevrserg.mobilex.main.CiceroneNavigationProvider
import com.makeevrserg.mobilex.ktx_core.UIDialogMessage
import com.makeevrserg.mobilex.core.lazyViewModel
import com.makeevrserg.mobilex.core.presentation.BindingFragment
import com.makeevrserg.mobilex.CoreAlertUiDialog
import com.makeevrserg.mobilex.CoreProgressDialog
import com.makeevrserg.mobilex.modules.RouterModule
import com.makeevrserg.mobilex.core.routing.IRouter
import com.makeevrserg.mobilex.core.ui.IUiDialogListener
import com.makeevrserg.mobilex.core.ui.IUiLoadingListener
import com.makeevrserg.mobilex.core.ui.IUiMessageListener
import com.makeevrserg.mobilex.core.ui.IUiRouteListener



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


