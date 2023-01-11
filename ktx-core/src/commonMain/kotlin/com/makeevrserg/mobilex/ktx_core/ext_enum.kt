package com.makeevrserg.mobilex.ktx_core


/**
 * Safely get value from enum with type [T]
 * @return T or null if value in [Enum] not found
 */
inline fun <reified T : Enum<T>> valueOfOrNull(type: String, valueOf: (String) -> T): T? = runCatching {
    valueOf(type)
}.getOrNull()

inline fun <reified T : kotlin.Enum<T>> T.addIndex(offset: Int, values: Array<T>): T {
    var res = ordinal + offset
    if (res <= -1) res = values.size - 1
    val index = res % values.size
    return values[index]
}

inline fun <reified T : kotlin.Enum<T>> T.next(values: Array<T>): T {
    return addIndex(1, values)
}

inline fun <reified T : kotlin.Enum<T>> T.prev(values: Array<T>): T {
    return addIndex(-1, values)
}