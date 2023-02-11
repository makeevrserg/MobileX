package com.makeevrserg.mobilex.moko_mvi

import com.makeevrserg.mobilex.mvi.Container

actual open class CContainer<STATE : Any, SIDE_EFFECT : Any> actual constructor(
    private val container: Container<STATE, SIDE_EFFECT>
) : Container<STATE, SIDE_EFFECT> by container