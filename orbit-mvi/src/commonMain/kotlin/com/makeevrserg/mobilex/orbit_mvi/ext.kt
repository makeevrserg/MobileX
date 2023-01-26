package com.makeevrserg.mobilex.orbit_mvi

import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.annotation.OrbitDsl
import org.orbitmvi.orbit.syntax.simple.SimpleContext
import org.orbitmvi.orbit.syntax.simple.SimpleSyntax
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

@OrbitDsl
public suspend inline fun <reified S : Any, reified CS : S> SimpleSyntax<S, *>.reduceState(
    noinline reducer: SimpleContext<CS>.() -> S
) {
    reduce {
        (this.state as? CS)?.let { SimpleContext(it).reducer() } ?: state
    }
}

@OrbitDsl
public suspend fun <T:Any> T.postSideEffect(simpleSyntax: SimpleSyntax<*, T>) {
    simpleSyntax.postSideEffect(this)
}