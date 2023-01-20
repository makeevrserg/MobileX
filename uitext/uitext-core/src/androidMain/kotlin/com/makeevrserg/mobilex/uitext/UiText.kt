package com.makeevrserg.mobilex.uitext

import android.content.Context
import androidx.annotation.StringRes

actual sealed interface UiText {
    class DynamicString(
        val value: String,
        vararg val args: Pair<String, String>
    ) : UiText

    class StringResource(
        @StringRes val resId: Int,
        vararg val args: Pair<String, String>
    ) : UiText

    fun asString(context: Context): String {
        return when (this) {
            is DynamicString -> withArgs(value, *args)
            is StringResource -> withArgs(context.getString(resId), *args)
        }
    }

    actual companion object {
        actual operator fun invoke(
            value: String,
            vararg args: Pair<String, String>
        ): UiText = UiText.DynamicString(value, *args)

        operator fun invoke(
            @StringRes resource: Int,
            vararg args: Pair<String, String>
        ): UiText = UiText.StringResource(resource, *args)
    }
}
