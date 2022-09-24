package com.makeevrserg.mvvmcore.core_compose.components.expandable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun ExpandableCard(
    lineType: LineType,
    elevation: Dp = 1.dp,
    backgroundColor: Color,
    headerTitle: @Composable () -> Unit,
    icon: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    var expand by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(if (expand) 180f else 0f)
    ExpandableComponent(
        lineType = lineType,
        elevation = elevation,
        backgroundColor = backgroundColor,
        header = { isExpanded, onClick ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        expand = !isExpanded
                        onClick.invoke()
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween // Control the header Alignment over here.
            ) {
                headerTitle()
                IconButton(
                    modifier = Modifier
                        .rotate(rotationState)
                        .weight(.1f),
                    onClick = {
                        expand = !isExpanded
                        onClick.invoke()
                    }
                ) {
                    icon()
                }
            }
        },
        content = {
            Column {
                content.invoke()
            }
        }
    )

}