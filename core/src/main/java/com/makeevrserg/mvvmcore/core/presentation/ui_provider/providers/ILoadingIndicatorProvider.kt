package com.makeevrserg.mvvmcore.core.presentation.ui_provider.providers

import kotlinx.coroutines.flow.StateFlow

interface ILoadingIndicatorProvider {
    val loadingIndicator: StateFlow<Boolean>
}
