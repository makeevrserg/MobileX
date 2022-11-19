package com.makeevrserg.mobilex.ktx_core

/**
 * When you'll recieve null from api, for example, this function will make a few attemptes to fetch non-null value
 */
suspend fun <T> withGenericAttempt(maxAmount: Int, block: suspend () -> T?): T? {
    var attemptsLeft = maxAmount
    var result = block()
    while (result == null && attemptsLeft > 0) {
        result = block()
        attemptsLeft--
    }
    return result
}