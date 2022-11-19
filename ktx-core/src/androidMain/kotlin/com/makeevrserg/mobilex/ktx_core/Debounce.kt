package com.makeevrserg.mobilex.ktx_core

import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Deprecated("Does this class violate something?")
class Debounce(private val millis: Long) {

    private var job: Job? = null

    private val currentTimeMillis: Long
        get() = System.currentTimeMillis()

    private var startedAt: Long = 0L

    suspend fun launch(block: () -> Unit) {
        if (job?.isActive == true) return
        if (currentTimeMillis - startedAt < millis) return
        startedAt = currentTimeMillis
        job = coroutineScope {
            this.launch(this.coroutineContext) {
                block()
                job = null
            }
        }
    }


}
