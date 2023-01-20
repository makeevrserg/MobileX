package com.makeevrserg.mobilex.uitext

import dev.icerock.moko.resources.StringResource

actual operator fun UiText.Companion.invoke(
    resource: StringResource,
    vararg args: Pair<String, String>
): UiText = UiText(resource.key, resource.bundleName, resource.resourcesClassLoader, *args)