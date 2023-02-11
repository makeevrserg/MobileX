package com.makeevrserg.mobilex.ktx_core

import kotlin.contracts.ExperimentalContracts

fun interface SealedExceptionHandler<T : Throwable> : Function<T> {
    fun handle(e: T)
}

@OptIn(ExperimentalContracts::class)
public inline fun <T, reified K : Throwable> Result<T>.onSealedFailure(handler: SealedExceptionHandler<K>): Result<T> {
    kotlin.contracts.contract {
        callsInPlace(handler, kotlin.contracts.InvocationKind.AT_MOST_ONCE)
    }
    (exceptionOrNull() as? K)?.let(handler::handle)
    return this
}