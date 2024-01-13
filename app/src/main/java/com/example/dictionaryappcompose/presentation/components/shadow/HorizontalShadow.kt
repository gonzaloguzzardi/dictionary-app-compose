package com.example.dictionaryappcompose.presentation.components.shadow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalShadow(
    modifier: Modifier,
    descendingShadow: Boolean = true,
    height: Dp = 4.dp
) {
    val shadowColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.1f)
    val banishedShadowColor = shadowColor.copy(alpha = 0f)
    val colors = if (descendingShadow) listOf(shadowColor, banishedShadowColor) else listOf(
        banishedShadowColor,
        shadowColor
    )
    Box(
        modifier = modifier
            .height(height)
            .background(
                brush = Brush.verticalGradient(
                    colors = colors
                )
            )
    )
}

@Preview(showBackground = true)
@Composable
fun HorizontalShadowPreview() {
    HorizontalShadow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp)
    )
}
