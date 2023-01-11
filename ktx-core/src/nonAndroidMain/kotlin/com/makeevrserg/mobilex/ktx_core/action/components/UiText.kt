package com.makeevrserg.mobilex.ktx_core.action.components


/**
 * This class allows to create messages from ViewModel without context
 * The compose integration also avaliable in core-compose
 */
actual sealed interface UiText {
    companion object {
        operator fun invoke(
            raw: String,
            vararg args: Pair<String, String>
        ): UiText = DynamicString(raw, *args)
    }


    class DynamicString(
        val value: String,
        vararg val args: Pair<String, String>
    ) : UiText

    fun asString(): String {
        return when (this) {
            is DynamicString -> withArgs(value, *args)
        }
    }
}
