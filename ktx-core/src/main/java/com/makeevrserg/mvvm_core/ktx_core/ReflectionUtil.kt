package com.makeevrserg.mvvm_core.ktx_core

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

object ReflectionUtil {
    @Suppress("UNCHECKED_CAST")
    fun <T, K> getDeclaredField(clazz: Class<T>, name: String): K? = kotlin.runCatching {
        clazz.getDeclaredField(name).run {
            isAccessible = true
            val field = this.get(null)
            isAccessible = false
            field as? K?
        }
    }.getOrNull()

    @Suppress("UNCHECKED_CAST")
    fun <T, K> getField(clazz: Class<T>, name: String): K? = kotlin.runCatching {
        clazz.getField(name).run {
            isAccessible = true
            val field = this.get(null)
            isAccessible = false
            field as? K?
        }
    }.getOrNull()

    fun <T, K> setDeclaredField(clazz: Class<T>, instance: Any, name: String, value: K?) =
        kotlin.runCatching {
            clazz.getDeclaredField(name).run {
                isAccessible = true
                set(instance, value)
                isAccessible = false
            }

        }.getOrNull()


}