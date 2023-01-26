package com.makeevrserg.mobilex.orbit_mvi

import dev.icerock.moko.mvvm.flow.CFlow
import dev.icerock.moko.mvvm.flow.CStateFlow
import dev.icerock.moko.mvvm.flow.cFlow
import dev.icerock.moko.mvvm.flow.cStateFlow
import org.orbitmvi.orbit.Container

actual class CContainer<STATE : Any, SIDE_EFFECT : Any> actual constructor(
    public val container: Container<STATE, SIDE_EFFECT>,
) : Container<STATE, SIDE_EFFECT> by container {
    public val cStateFlow: CStateFlow<STATE>
        get() = container.stateFlow.cStateFlow()
    public val cSideEffectFlow: CFlow<SIDE_EFFECT>
        get() = container.sideEffectFlow.cFlow()
}