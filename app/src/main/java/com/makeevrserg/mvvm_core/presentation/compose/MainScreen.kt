package com.makeevrserg.mvvm_core.presentation.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.makeevrserg.mvvm_core.presentation.compose.components.ConfirmDialog
import com.makeevrserg.mvvm_core.presentation.compose.components.MyLoadingIndication
import com.makeevrserg.mvvm_core.presentation.compose.components.RowButon
import com.makeevrserg.mvvm_core.presentation.main.MainViewModel
import com.makeevrserg.mvvmcore.core.lazyViewModel
import com.makeevrserg.mvvmcore.core.routing.IRouter
import com.makeevrserg.mvvmcore.core_compose.ui.UIDialogListener
import com.makeevrserg.mvvmcore.core_compose.ui.UIRouteListener
import com.makeevrserg.mvvmcore.core_compose.ui.UiLoadingListener
import com.makeevrserg.mvvmcore.core_compose.ui.UiMessageListener

@Composable
fun MainScreen(router: IRouter<ComposeScreen>) {
    val viewModel: MainViewModel = MainViewModel()
    LazyColumn {
        item {
            RowButon("Toast") {
                viewModel.onShowToastClicked()
            }
        }
        item {
            RowButon("Snackbar") {
                viewModel.onShoSnackbarClicked()
            }
        }
        item {
            RowButon("Dialog") {
                viewModel.onShowDialogClicked()
            }
        }
        item {
            RowButon("Loading") {
                viewModel.onShowLoadingClicked()
            }
        }

        item {
            RowButon("Open Screen") {
                viewModel.openComposeScreen()
            }
        }
    }
    UIRouteListener(action = viewModel, navHostRouter = router)
    UiMessageListener(action = viewModel)
    UiLoadingListener(action = viewModel) {
        MyLoadingIndication(it)
    }
    UIDialogListener(action = viewModel) {
        ConfirmDialog(message = it)
    }
}