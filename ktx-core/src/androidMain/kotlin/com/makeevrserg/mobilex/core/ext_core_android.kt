@file:Suppress("Filename")

package com.makeevrserg.mobilex.core

import android.os.Build
import android.os.Bundle
import java.io.Serializable

inline fun <reified T : Serializable> simpleName() = T::class.java.simpleName

/**
 * Save [Serializable] in bundle without passing a name
 */
inline fun <reified T : Serializable> Bundle.getSerializable(): T? =
    getSerializable(this, simpleName<T>(), T::class.java)

/**
 * Get [Serializable] from bundle without passing a name and consider a version
 */
inline fun <reified T : Serializable> getSerializable(bundle: Bundle, key: String, clazz: Class<T>): T? {
    return if (Build.VERSION.SDK_INT >= 33) {
        bundle.getSerializable(key, clazz)
    } else {
        bundle.getSerializable(key) as? T?
    }
}
