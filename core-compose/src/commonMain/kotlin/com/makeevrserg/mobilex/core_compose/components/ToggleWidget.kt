package com.makeevrserg.mobilex.core_compose.components

import androidx.compose.runtime.Composable

interface ToggleWidget {
    fun toggle()

    @Composable
    fun render()
}