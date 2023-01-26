package com.makeevrserg.mobilex.moko_mvi

import com.makeevrserg.mobilex.mvi.Container

expect open class CContainer<STATE : Any, SIDE_EFFECT : Any>(
    container: Container<STATE, SIDE_EFFECT>
) : Container<STATE, SIDE_EFFECT>

fun <STATE : Any, SIDE_EFFECT : Any> Container<STATE,SIDE_EFFECT>.cContainer(): CContainer<STATE,SIDE_EFFECT> = CContainer(this)