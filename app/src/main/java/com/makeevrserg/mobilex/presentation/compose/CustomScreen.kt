package com.makeevrserg.mobilex.presentation.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.makeevrserg.mobilex.presentation.compose.components.RowButon
import com.makeevrserg.mobilex.core.routing.IRouter

@Composable
fun CustomScreen(router: IRouter<ComposeScreen>, string: String) {

    LazyColumn {
        item {
            RowButon("$string + ${router.isBackStackEmpty}") {

            }
        }
    }
}