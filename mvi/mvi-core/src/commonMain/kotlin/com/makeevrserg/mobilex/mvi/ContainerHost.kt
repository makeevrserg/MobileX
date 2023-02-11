package com.makeevrserg.mobilex.mvi

interface ContainerHost<STATE : Any, SIDE_EFFECT : Any, INTENT : Any> {
    val container: Container<STATE, SIDE_EFFECT>
    fun onIntent(intent: INTENT)

    suspend fun SIDE_EFFECT.sendSideEffect() {
        container.send(this)
    }

}

