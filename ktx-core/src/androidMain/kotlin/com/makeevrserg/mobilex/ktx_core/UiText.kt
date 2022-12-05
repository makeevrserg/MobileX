package com.makeevrserg.mobilex.ktx_core

import android.content.Context
import androidx.annotation.StringRes


/**
 * This class allows to create messages from ViewModel without context
 * The compose integration also avaliable in core-compose
 */
actual sealed interface UiText {
    companion object {
        operator fun invoke(
            @StringRes resId: Int,
            vararg args: Pair<String, String>
        ): UiText = StringResource(resId, *args)

        operator fun invoke(
            raw: String,
            vararg args: Pair<String, String>
        ): UiText = DynamicString(raw, *args)
    }


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

    /**
     * Если у текста есть аргументы вроде %name% - в [args] можно передать например %name% to user.name
     */
    fun withArgs(line: String, vararg args: Pair<String, String>): String {
        var line = line
        args.forEach {
            line = line.replace(it.first, it.second)
        }
        return line
    }
}

actual fun uiText(value: String): UiText = UiText.DynamicString(value)