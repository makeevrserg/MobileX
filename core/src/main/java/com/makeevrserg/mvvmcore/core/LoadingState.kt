package com.makeevrserg.mvvmcore.core

/**
 * This loading state is useful in custom ui states.
 * For example list loading from REST-api
 */
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