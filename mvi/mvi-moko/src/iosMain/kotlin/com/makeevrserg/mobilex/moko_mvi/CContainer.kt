package com.makeevrserg.mobilex.moko_mvi

import com.makeevrserg.mobilex.mvi.Container
import dev.icerock.moko.mvvm.flow.*

actual open class CContainer<STATE : Any, SIDE_EFFECT : Any> actual constructor(
    private val container: Container<STATE, SIDE_EFFECT>
) : Container<STATE, SIDE_EFFECT> by container {
    val cSideEffectFlow: CFlow<SIDE_EFFECT>
        get() = sideEffectFlow.cFlow()
    val cMutableStateFlow: CMutableStateFlow<STATE>
        get() = mutableStateFlow.cMutableStateFlow()
    val cStateFlow: CStateFlow<STATE>
        get() = mutableStateFlow.cStateFlow()
}