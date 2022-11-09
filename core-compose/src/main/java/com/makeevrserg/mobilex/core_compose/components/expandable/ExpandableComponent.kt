package com.makeevrserg.mobilex.core_compose.components.expandable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ExpandableComponent(
    header: @Composable (expanded: Boolean, onClick: () -> Unit) -> Unit,
    backgroundColor: Color,
    lineType: LineType,
    shape: Shape = RoundedCornerShape(4.dp),
    elevation: Dp = 1.dp,
    initiallyExpanded: Boolean = false,
    content: @Composable () -> Unit,
) {
    var expand by remember { mutableStateOf(initiallyExpanded) } // Expand State
    Card(
        modifier = Modifier
            .animateContentSize( // Animation
                animationSpec = tween(
                    durationMillis = 70, // Animation Speed
                    easing = LinearOutSlowInEasing // Animation Type
                )
            )
            .padding(8.dp),
        backgroundColor = backgroundColor,
        shape = shape, // Shape
        elevation = elevation,
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            header(expand) {
                expand = !expand
            }

            AnimatedVisibility(visible = expand) {
                lineType.Create()
                content.invoke()
            }
        }
    }
}