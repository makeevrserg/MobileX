package com.makeevrserg.mvvmcore.core_compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.makeevrserg.mvvmcore.core.UiText

@Composable
fun <T> LiveData<T>.Observe(observer: Observer<T>) {
    this.observe(LocalLifecycleOwner.current, observer)
}

@Composable
fun UiText.asString(): String {
    return when (this) {
        is UiText.DynamicString -> value
        is UiText.StringResource -> stringResource(id = resId)
    }
}