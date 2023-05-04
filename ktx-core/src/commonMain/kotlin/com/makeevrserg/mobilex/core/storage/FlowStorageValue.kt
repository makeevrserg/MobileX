package com.makeevrserg.mobilex.core.storage

import kotlinx.coroutines.flow.StateFlow

/**
 * FlowStorageValue<T> allows you to use your storage values in reactive way
 */
interface FlowStorageValue<T> : StorageValue<T> {
    val stateFlow: StateFlow<T>

    override val value: T
        get() = stateFlow.value
}
