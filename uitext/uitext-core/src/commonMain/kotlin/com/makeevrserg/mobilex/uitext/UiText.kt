package com.makeevrserg.mobilex.uitext

expect sealed interface UiText {
    companion object {
        /**
         * Returns UiText with Raw string value
         */
        operator fun invoke(value: String,vararg args: Pair<String, String>): UiText
    }
}