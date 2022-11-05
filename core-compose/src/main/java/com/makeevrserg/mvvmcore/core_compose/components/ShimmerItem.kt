package com.makeevrserg.mvvmcore.core_compose.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ShimmerItem(modifier: Modifier, color: Color) {
    val gradient = listOf(
        color, //darker grey (90% opacity)
        color.copy(alpha = 0.75f), //lighter grey (30% opacity)
        color
    )

    val transition = rememberInfiniteTransition() // animate infinite times

    val translateAnimation = transition.animateFloat( //animate the transition
        initialValue = 0f,
        targetValue = 2000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000, // duration for the animation
                easing = FastOutLinearInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
    val brush = Brush.linearGradient(
        colors = gradient,
        start = Offset(0f, 0f),
        end = Offset(
            x = translateAnimation.value,
            y = translateAnimation.value
        )
    )
    Spacer(
        modifier = modifier
            .background(brush)
    )
}