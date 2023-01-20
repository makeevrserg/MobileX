package com.makeevrserg.mobilex.uitext

import dev.icerock.moko.resources.StringResource


expect operator fun UiText.Companion.invoke(
    resource: StringResource,
    vararg args: Pair<String, String>
): UiText