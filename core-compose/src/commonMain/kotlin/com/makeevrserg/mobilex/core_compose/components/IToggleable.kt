package com.makeevrserg.mobilex.core_compose.components

import androidx.compose.runtime.Composable

interface IToggleable {
    fun toggle()

    @Composable
    fun render()
}