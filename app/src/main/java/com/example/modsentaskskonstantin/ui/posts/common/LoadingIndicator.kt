package com.example.modsentaskskonstantin.ui.posts.common

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.modsentaskskonstantin.R

@Composable
fun LoadingIndicator() {
    val infinite = rememberInfiniteTransition(label = "")
    val angle by infinite.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(tween(800, easing = LinearEasing)), label = ""
    )
    Icon(
        painter = painterResource(R.drawable.loader_icon),
        contentDescription = null,
        modifier = Modifier
            .size(48.dp)
            .rotate(angle)
    )
}
