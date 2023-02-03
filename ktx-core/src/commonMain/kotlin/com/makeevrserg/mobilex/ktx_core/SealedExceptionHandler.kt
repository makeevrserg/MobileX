package com.makeevrserg.mobilex.ktx_core

fun interface SealedExceptionHandler<T : Throwable> {
    fun handle(e: T)
    companion object{
        inline fun <reified T : Throwable, reified L> handle(
            handler: SealedExceptionHandler<T>,
            block: () -> L
        ) = runCatching(block).onFailure {
            (it as? T)?.let(handler::handle)
        }.getOrNull()
    }
}
