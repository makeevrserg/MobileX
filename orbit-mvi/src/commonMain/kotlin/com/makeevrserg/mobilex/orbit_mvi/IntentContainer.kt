package com.makeevrserg.mobilex.orbit_mvi

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container
import org.orbitmvi.orbit.syntax.simple.*

interface IntentContainer<STATE : Any, SIDE_EFFECT : Any, INTENT : Any> :
    ContainerHost<STATE, SIDE_EFFECT> {
    override val container: Container<STATE, SIDE_EFFECT>
    fun onIntent(intent: INTENT)
}