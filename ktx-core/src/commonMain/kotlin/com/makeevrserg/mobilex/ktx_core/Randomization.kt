package com.makeevrserg.mobilex.ktx_core

import kotlin.random.Random
import kotlin.reflect.KClass

/**
 * Useful for generating custom random domain model data
 */
object Randomization {
    private const val CHARS = "qwertyuiopasdfghjklzxcvbnm"
    private fun randomString() = List(Random.nextInt(4, 10)) { CHARS.random() }.joinToString("").capitalize()
    fun <T> ofList(size: Int = 10, builder: () -> T): List<T> =
        IntRange(0, size).map { builder() }

    inline fun <reified T: Any> randomize(): T = randomize(T::class) as T

    fun <T: Any> randomize(klazz: KClass<T>): Any = when (klazz) {
        Int::class -> Random.nextInt(Int.MAX_VALUE)
        Long::class -> Random.nextInt(Int.MAX_VALUE).toLong()
        String::class -> randomString()
        Double::class -> Random.nextDouble(Double.MAX_VALUE)
        Float::class -> Random.nextDouble(Double.MAX_VALUE).toFloat()
        Char::class -> randomString()
        Boolean::class -> Random.nextBoolean()
        else -> throw Exception("Unknown type ${klazz}")
    }
}
