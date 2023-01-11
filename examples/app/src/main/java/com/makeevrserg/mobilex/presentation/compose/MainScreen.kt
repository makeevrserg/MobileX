package com.makeevrserg.mobilex.presentation.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.makeevrserg.mobilex.presentation.compose.components.ConfirmDialog
import com.makeevrserg.mobilex.presentation.compose.components.MyLoadingIndication
import com.makeevrserg.mobilex.presentation.compose.components.RowButon
import com.makeevrserg.mobilex.presentation.main.MainViewModel

@Composable
fun MainScreen() {
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
}