package com.makeevrserg.mobilex.orbit_mvi

import dev.icerock.moko.mvvm.flow.cFlow
import dev.icerock.moko.mvvm.flow.cStateFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import org.orbitmvi.orbit.Container

expect class CContainer<STATE : Any, SIDE_EFFECT : Any>(
    container: Container<STATE, SIDE_EFFECT>
) : Container<STATE, SIDE_EFFECT>

fun <STATE : Any, SIDE_EFFECT : Any> Container<STATE, SIDE_EFFECT>.cContainer(): CContainer<STATE, SIDE_EFFECT> {
    return CContainer(this)
}