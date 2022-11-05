package com.makeevrserg.mvvm_core.presentation.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.makeevrserg.mvvm_core.presentation.compose.components.RowButon
import com.makeevrserg.mvvmcore.core.routing.IRouter

@Composable
fun CustomScreen(router: IRouter<ComposeScreen>, string: String) {

    LazyColumn {
        item {
            RowButon("$string + ${router.isBackStackEmpty}") {

            }
        }
    }
}