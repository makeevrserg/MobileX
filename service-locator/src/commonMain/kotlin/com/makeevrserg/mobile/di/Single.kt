package com.makeevrserg.mobile.di

/**
 * [Single] is a singleton value which will be a unique and single instant
 *
 * This can be helpful for repository storing, DB connection and etc
 */
class Single<out T>(factory: Factory<T>) : Dependency<T> {
    private val instance by lazy {
        factory.create()
    }
    override val value: T
        get() = instance
}
