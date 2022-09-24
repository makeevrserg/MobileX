package com.makeevrserg.mvvmcore.core.randomization

import java.util.UUID
import kotlin.random.Random

/**
 * Useful for generating custom random domain model data
 */
object Randomization {
    fun <T> ofList(size: Int = 10, builder: () -> T): List<T> =
        IntRange(0, size).map { builder() }

    inline fun <reified T> randomize(): T = randomize(T::class.java)

    fun <T> randomize(clazz: Class<T>): T = when (clazz) {
        Int::class.java -> Random.nextInt(Int.MAX_VALUE) as T
        Long::class.java -> Random.nextInt(Int.MAX_VALUE).toLong() as T
        String::class.java -> UUID.randomUUID().toString() as T
        Double::class.java -> Random.nextDouble(Double.MAX_VALUE) as T
        Float::class.java -> Random.nextDouble(Double.MAX_VALUE).toFloat() as T
        Char::class.java -> UUID.randomUUID().toString()[0] as T
        Boolean::class.java -> Random.nextBoolean() as T
        java.lang.Boolean::class.java -> Random.nextBoolean() as T
        java.lang.Integer::class.java -> Random.nextInt(Int.MAX_VALUE) as T
        else -> throw Exception("Unknown type ${clazz}")
    }
}
