package com.makeevrserg.mobilex.core_compose.components

import androidx.compose.runtime.Composable

@Composable
internal expect fun Dialog(onDismissRequest: () -> Unit, content: @Composable () -> Unit)