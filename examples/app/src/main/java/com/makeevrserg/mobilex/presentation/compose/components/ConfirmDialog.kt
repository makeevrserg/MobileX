package com.makeevrserg.mobilex.presentation.compose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.makeevrserg.mobilex.core_compose.asString
import com.makeevrserg.mobilex.ktx_core.UIDialogMessage
@Composable
fun ConfirmDialog(
    message: UIDialogMessage,
) {
    CustomDialog(title = {
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
            color = MaterialTheme.colors.primary,
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