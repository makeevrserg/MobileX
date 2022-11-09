package com.makeevrserg.mobilex.presentation.compose.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun RowButon(text: String, onClick: () -> Unit) {
    Button(modifier = Modifier.fillMaxWidth(), onClick = onClick) {
        Text(text, color = Color.Cyan)

    }
}