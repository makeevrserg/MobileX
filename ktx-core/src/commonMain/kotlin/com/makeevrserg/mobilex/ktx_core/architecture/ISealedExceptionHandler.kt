package com.makeevrserg.mobilex.ktx_core.architecture

fun interface ISealedExceptionHandler<T : Exception> {
    fun handle(e: T)
    companion object{
        inline fun <reified T : Exception, reified L> handle(
            handler: ISealedExceptionHandler<T>,
            block: () -> L
        ) = runCatching(block).onFailure {
            (it as? T)?.let(handler::handle)
        }.getOrNull()
    }
}
