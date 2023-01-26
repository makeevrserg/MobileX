package com.makeevrserg.mobilex.orbit_mvi

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.observe

interface ContainerListener<STATE : Any, SIDE_EFFECT : Any> : LifecycleOwner {
    suspend fun onState(state: STATE)
    suspend fun onSideEffect(sideEffect: SIDE_EFFECT)
    fun collectState(
        lifecycleOwner: LifecycleOwner,
        lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
        container: ContainerHost<STATE, SIDE_EFFECT>
    ) = container.observe(lifecycleOwner, lifecycleState, ::onState, ::onSideEffect)
}
