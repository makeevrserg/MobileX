package com.makeevrserg.mobilex.desktop

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.window.singleWindowApplication

fun main() {
    singleWindowApplication {
        Button(onClick = {
        }) {
            Text("Click to connect")
        }

    }
}