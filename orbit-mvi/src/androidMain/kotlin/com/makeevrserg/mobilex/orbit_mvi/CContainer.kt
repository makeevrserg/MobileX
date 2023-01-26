package com.makeevrserg.mobilex.orbit_mvi

import org.orbitmvi.orbit.Container

actual class CContainer<STATE : Any, SIDE_EFFECT : Any> actual constructor(
    container: Container<STATE, SIDE_EFFECT>
) : Container<STATE, SIDE_EFFECT> by container