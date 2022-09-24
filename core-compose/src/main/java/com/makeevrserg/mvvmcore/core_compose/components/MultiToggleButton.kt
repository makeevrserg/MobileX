package com.makeevrserg.mvvmcore.core_compose.components


import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
@Preview
private fun _MultiToggleButton() {
    var selectionIndex by remember { mutableStateOf(0) }
    Surface(Modifier.fillMaxSize(), color = Color(0xFF222222)) {
        Box {
            MultiToggleButton(currentSelection = selectionIndex,
                toggleStates = listOf("Online", "Offline", "Unrecognized"),
                textBuilder = { text, isSelected ->
                    Text(
                        text = text, style = TextStyle(
                            color = if (isSelected) Color(0xFF222222) else Color(0xFFFFFFFF)
                        ), modifier = Modifier.padding(8.dp)
                    )
                },
                background = Color(0xFF222222),
                backgroundTint = {
                    if (it) Color(0xFFFFFFFF) else Color(0xFF222222)
                }) {
                selectionIndex = it
            }
        }
    }

}

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
