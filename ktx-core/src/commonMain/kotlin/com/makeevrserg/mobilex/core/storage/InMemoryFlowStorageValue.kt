package com.makeevrserg.mobilex.core.storage

class InMemoryFlowStorageValue<T>(
    default: T
) : FlowStorageValue<T> by DefaultFlowStorageValue<T>(
    default = default,
    loadSettingsValue = { default },
    saveSettingsValue = {}
)
