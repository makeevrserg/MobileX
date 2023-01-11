package com.makeevrserg.mobilex.presentation.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.makeevrserg.mobilex.presentation.compose.components.RowButon

@Composable
fun CustomScreen(string: String) {

    LazyColumn {
        item {
            RowButon("$string + ") {

            }
        }
    }
}