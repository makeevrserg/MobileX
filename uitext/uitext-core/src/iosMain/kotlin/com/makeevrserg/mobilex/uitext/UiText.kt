package com.makeevrserg.mobilex.uitext

import platform.Foundation.NSBundle
import platform.Foundation.NSLocale
import platform.Foundation.currentLocale

actual sealed interface UiText {
    class DynamicString(
        val value: String,
        vararg val args: Pair<String, String>
    ) : UiText

    class StringResource(
        val resourceID: String,
        val bundle: NSBundle,
        vararg val args: Pair<String, String>
    ) : UiText

    fun asString(): String {

        return when (this) {
            is DynamicString -> withArgs(value, *args)
            is StringResource -> bundle.localizedStringForKey(resourceID, null, null)
        }
    }

    actual companion object {
        actual operator fun invoke(
            value: String,
            vararg args: Pair<String, String>
        ): UiText = UiText.DynamicString(value, *args)

        operator fun invoke(
            resourceID: String,
            bundle: NSBundle,
            vararg args: Pair<String, String>
        ): UiText = UiText.StringResource(resourceID, bundle, *args)
    }
}
