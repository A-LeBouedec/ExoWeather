package com.example.exoweather.feature.weather.presentation.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProgressBar(
    modifier: Modifier = Modifier,
    progress: Float,
    title: String? = null
) {
    val loaderSize by animateFloatAsState(
        targetValue = progress,
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )

    Column(
        modifier = modifier
            .padding(
                horizontal = 30.dp,
                vertical = 10.dp
            )
    ) {
        // Title
        if (title != null) {
            Text(
                text = title,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        // ProgressBar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        ) {
            // Background of the ProgressBar
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.LightGray)
            )
            // Loader of the ProgressBar
            Box(
                modifier = Modifier
                    .fillMaxWidth(loaderSize)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(15.dp))
                    .background(
                        Brush.horizontalGradient(
                            listOf(
                                Color.Magenta,
                                Color.Cyan
                            )
                        )
                    )
                    .animateContentSize()
            )
            // Progress text in percentage
            Text(
                text = "${(progress * 100).toInt()} %",
                modifier = Modifier.align(Alignment.Center),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}
