package com.makeevrserg.mobilex.core_compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.makeevrserg.mobilex.ktx_core.architecture.INotifier
import kotlinx.coroutines.flow.Flow

@Composable
fun <T> INotifier<T>.CollectLatest(block: (T) -> Unit) {
    val collected by flow.collectAsState(initial)
    block(collected)
}