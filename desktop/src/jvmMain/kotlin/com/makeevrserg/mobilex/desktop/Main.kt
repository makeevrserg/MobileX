package com.makeevrserg.mobilex.desktop

import androidx.compose.foundation.layout.Column
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.singleWindowApplication
import com.makeevrserg.mobilex.core_compose.ui.UIDialogListener
import com.makeevrserg.mobilex.core_compose.ui.UiMessageListener
import com.makeevrserg.mobilex.ktx_core.UIDialogButton
import com.makeevrserg.mobilex.ktx_core.UIDialogMessage
import com.makeevrserg.mobilex.ktx_core.UiText
import com.makeevrserg.mobilex.ktx_core.ui.IUIDialogAction
import com.makeevrserg.mobilex.ktx_core.ui.IUIMessageAction
import com.makeevrserg.mobilex.ktx_core.ui.UIDialogAction
import com.makeevrserg.mobilex.ktx_core.ui.UIMessageAction

class ViewModel : IUIMessageAction by UIMessageAction(),
    IUIDialogAction by UIDialogAction() {

    fun onMessageClicked() {
        UiText("Hello world").sendSnackbar()
    }

    fun onDialogClicked() {
        UIDialogMessage(
            UiText("Title"),
            UiText("Description"),
            UIDialogButton(UiText("Yes")) {
                uiDialog.value = null
            },
            UIDialogButton(UiText("No")) {
                uiDialog.value = null
            }
        ).send()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UIDialog(it: UIDialogMessage) {
    AlertDialog(onDismissRequest = {}, buttons = {
        it.positiveButton?.let {
            Button(onClick = it.onClick) {
                Text(it.text.asString())
            }
        }
        it.negativeButton?.let {
            Button(onClick = it.onClick) {
                Text(it.text.asString())
            }
        }
    }, title = {
        Text(it.title.asString())
    }, text = {
        Text(it.description.asString())
    })
}

@OptIn(ExperimentalMaterialApi::class)
fun main() {
    val viewModel = ViewModel()
    singleWindowApplication {
        UiMessageListener(viewModel)
        UIDialogListener(viewModel) {
            UIDialog(it)
        }
        Column {
            Button(onClick = viewModel::onMessageClicked) {
                Text("Message")
            }

            Button(onClick = viewModel::onDialogClicked) {
                Text("Dialog")
            }

        }
    }
}