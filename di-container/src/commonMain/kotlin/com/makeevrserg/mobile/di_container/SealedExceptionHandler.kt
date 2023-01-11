package com.makeevrserg.mobile.di_container

fun interface SealedExceptionHandler<T : Exception> {
    fun handle(e: T)
    companion object{
        inline fun <reified T : Exception, reified L> handle(
            handler: SealedExceptionHandler<T>,
            block: () -> L
        ) = runCatching(block).onFailure {
            (it as? T)?.let(handler::handle)
        }.getOrNull()
    }
}
