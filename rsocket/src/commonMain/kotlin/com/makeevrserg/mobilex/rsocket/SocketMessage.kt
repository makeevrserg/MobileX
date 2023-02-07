package com.makeevrserg.mobilex.rsocket

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.withTimeout
import kotlin.random.Random

interface SocketMessage<T, ID> {
    fun toJson(): String
    fun fromJson(json: String): T
    val id: ID
}