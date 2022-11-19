package com.makeevrserg.mobilex.presentation.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.makeevrserg.mobilex.presentation.compose.components.ConfirmDialog
import com.makeevrserg.mobilex.presentation.compose.components.MyLoadingIndication
import com.makeevrserg.mobilex.presentation.compose.components.RowButon
import com.makeevrserg.mobilex.presentation.main.MainViewModel
import com.makeevrserg.mobilex.core.routing.IRouter
import com.makeevrserg.mobilex.core_compose.ui.UIDialogListener
import com.makeevrserg.mobilex.core_compose.ui.UIRouteListener
import com.makeevrserg.mobilex.core_compose.ui.UiLoadingListener
import com.makeevrserg.mobilex.core_compose.ui.UiMessageListener

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