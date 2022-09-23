package com.makeevrserg.mvvmcore.core

sealed interface LoadingState {
    object Loading : LoadingState
    object Loaded : LoadingState
    object Error : LoadingState

    val isLoading: Boolean
        get() = this is Loading
    val isLoaded: Boolean
        get() = this is Loaded
    val isError: Boolean
        get() = this is Error
}