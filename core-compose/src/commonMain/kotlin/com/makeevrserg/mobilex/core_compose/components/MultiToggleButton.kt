package com.makeevrserg.mobilex.core_compose.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp


@Composable
fun MultiToggleButton(
    backgroundTint: (isSelected: Boolean) -> Color,
    textBuilder: @Composable (text: String, isSelected: Boolean) -> Unit,
    background: Color,
    currentSelection: Int,
    toggleStates: List<String>,
    shape: Shape = RoundedCornerShape(8.dp),
    onToggleChange: (Int) -> Unit
) {
    var count by remember { mutableStateOf(currentSelection) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .border(BorderStroke(1.dp, Color.LightGray), shape)
            .clip(shape)
            .background(background),
        horizontalArrangement = Arrangement.Center
    ) {
        toggleStates.forEachIndexed { i, text ->
            val isSelected = currentSelection == i
            val rowBackground = backgroundTint.invoke(isSelected)

            Row(
                horizontalArrangement = Arrangement.Center,
                content = { textBuilder(text, isSelected) },
                modifier = Modifier
                    .background(rowBackground, shape)
                    .weight(1f)
                    .clip(shape)
                    .toggleable(value = isSelected, enabled = true, onValueChange = { selected ->
                        if (selected) {
                            onToggleChange(i)
                        }
                    })
            )

        }
    }
}
