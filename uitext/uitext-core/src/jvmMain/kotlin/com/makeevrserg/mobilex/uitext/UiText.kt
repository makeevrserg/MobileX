package com.makeevrserg.mobilex.uitext

import java.util.*

actual sealed interface UiText {
    class DynamicString(
        val value: String,
        vararg val args: Pair<String, String>
    ) : UiText

    class StringResource(
        val key: String,
        val bundleName: String,
        val classLoader: ClassLoader,
        vararg val args: Pair<String, String>
    ) : UiText

    fun asString(): String {
        return when (this) {
            is DynamicString -> withArgs(value, *args)
            is StringResource -> {
                val resourcesBundle = ResourceBundle.getBundle(
                    bundleName,
                    Locale.getDefault(),
                    classLoader,
                    // Otherwise, the default locale will be picked from system settings
                    ResourceBundle.Control.getNoFallbackControl(ResourceBundle.Control.FORMAT_DEFAULT)
                )
                val value = resourcesBundle.getString(key)
                withArgs(value, *args)
            }
        }
    }

    actual companion object {
        actual operator fun invoke(
            value: String,
            vararg args: Pair<String, String>
        ): UiText = UiText.DynamicString(value, *args)

        operator fun invoke(
            key: String,
            bundleName: String,
            classLoader: ClassLoader,
            vararg args: Pair<String, String>
        ): UiText = UiText.StringResource(key, bundleName, classLoader, *args)
    }
}
