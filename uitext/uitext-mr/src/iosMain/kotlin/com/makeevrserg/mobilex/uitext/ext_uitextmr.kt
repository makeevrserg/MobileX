package com.makeevrserg.mobilex.uitext

import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.StringDesc


actual operator fun UiText.Companion.invoke(
    resource: StringResource,
    vararg args: Pair<String, String>
): UiText = UiText(resource.resourceId, resource.bundle, *args)