package com.makeevrserg.mvvmcore.core_compose.ui_provider

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalLifecycleOwner
import com.makeevrserg.mvvmcore.core.collectOn
import com.makeevrserg.mvvmcore.core.presentation.ui_provider.providers.ILoadingIndicatorProvider
import com.makeevrserg.mvvmcore.core_compose.collectOn


@Composable
fun LoadingIndicatorListener(
    provider: ILoadingIndicatorProvider,
    indicator: @Composable (Boolean) -> Unit
) {
    provider.loadingIndicator.collectAsState()?.value?.let {
        indicator(it)
    }
}