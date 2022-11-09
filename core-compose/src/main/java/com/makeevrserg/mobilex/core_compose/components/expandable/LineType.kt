package com.makeevrserg.mobilex.core_compose.components.expandable

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

sealed interface LineType {
    data class Dashed(val color: Color) : LineType
    data class Solid(val color: Color) : LineType
    object None : LineType

    @Composable
    fun Create() = when (this) {
        is Dashed -> DashedLine(color = color)
        is Solid -> Line(color = color)
        is None -> {}
    }
}