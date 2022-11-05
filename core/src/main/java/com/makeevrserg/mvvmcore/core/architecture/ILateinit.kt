package com.makeevrserg.mvvmcore.core.architecture

abstract class ILateinit<T : Any> {
    fun initialize(value: T) {
        this.value = value
    }

    lateinit var value: T
        private set
}