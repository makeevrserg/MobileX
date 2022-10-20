package com.makeevrserg.mvvm_core.presentation.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.makeevrserg.mvvm_core.presentation.main.MainViewModel
import com.makeevrserg.mvvmcore.core.ui.UIDialogMessage
import com.makeevrserg.mvvmcore.core.lazyViewModel
import com.makeevrserg.mvvmcore.core_compose.asString

class ExampleComposeActivity : ComponentActivity() {
    val viewModel: MainViewModel by lazyViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
            }
//            LoadingIndicatorListener(viewModel) { MyLoadingIndication(it) }
//            UiMessageListener(provider = viewModel)
//            UiDialogMessageListener(provider = viewModel) {
//                ConfirmDialog(it)
//            }
        }
    }
}

@Composable
fun CubicDialog(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    body: @Composable () -> Unit,
    footer: @Composable () -> Unit,
    onDismiss: () -> Unit
) {

    Dialog(onDismissRequest = { onDismiss() }, properties = DialogProperties()) {
        Surface(
            modifier = modifier,
            shape = RoundedCornerShape(8.dp),
            color = MaterialTheme.colors.background
        ) {

            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalAlignment = Alignment.Start
            ) {
                title()
                body()
                footer()
            }


        }
    }

}

@Composable
fun ConfirmDialog(
    message: UIDialogMessage,
) {
    CubicDialog(title = {
            Text(
                text = message.title.asString(),
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .fillMaxWidth(),
                fontSize = MaterialTheme.typography.h4.fontSize,
                color = MaterialTheme.colors.primary,
                textAlign = TextAlign.Start
            )
    }, body = {
            Text(
                text = message.description.asString(),
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .fillMaxWidth(),
                fontSize = MaterialTheme.typography.h6.fontSize,
                color =MaterialTheme.colors.primary,
                textAlign = TextAlign.Start
            )
    }, footer = {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            message.negativeButton?.let {
                TextButton(onClick = it.onClick) {
                    Text(it.text.asString(), color = MaterialTheme.colors.primary)
                }
            }
            message.positiveButton?.let {
                TextButton(onClick = it.onClick) {
                    Text(it.text.asString(), color = MaterialTheme.colors.primary)
                }
            }
        }
    }, onDismiss = {

    })
}

@Composable
fun MyLoadingIndication(isLoading: Boolean) {
    if (isLoading)
        Dialog(
            onDismissRequest = { },
            DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(24.dp * 3)
            ) {
                CircularProgressIndicator()
            }
        }

}

@Composable
fun RowButon(text: String, onClick: () -> Unit) {
    Button(modifier = Modifier.fillMaxWidth(), onClick = onClick) {
        Text(text, color = Color.Cyan)

    }
}