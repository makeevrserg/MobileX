package com.makeevrserg.mobilex.core_compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import com.makeevrserg.mobilex.mvi.ContainerHost
import kotlinx.coroutines.flow.collectLatest


@Composable
fun <T : Any> ContainerHost<T, *, *>.collectState(): State<T> = this.container.mutableStateFlow.collectAsState()


@Composable
inline fun <reified T : Any> ContainerHost<*, T, *>.observeSideEffect(crossinline onSideEffect: (T) -> Unit) {
    LaunchedEffect(this) {
        container.sideEffectFlow.collectLatest {
            it?.let(onSideEffect)
        }
    }
}