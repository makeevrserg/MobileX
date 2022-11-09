package com.makeevrserg.mobilex.presentation.compose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun CustomDialog(
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