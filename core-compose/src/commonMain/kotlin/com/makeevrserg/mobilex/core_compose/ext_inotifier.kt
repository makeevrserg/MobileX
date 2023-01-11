package com.makeevrserg.mobilex.core_compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.makeevrserg.mobile.di_container.Notifier

@Composable
fun <T> Notifier<T>.CollectLatest(block: (T) -> Unit) {
    val collected by flow.collectAsState(initial)
    block(collected)
}