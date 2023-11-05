package com.emilygoose.mastermind.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun ColorDot(color: Color, modifier: Modifier, onClick: () -> Unit = {}) {
    Box(
        modifier = modifier
    ) {
        IconButton(onClick = onClick) {
            Icon(
                imageVector = Icons.Filled.Circle,
                contentDescription = "Guess dot",
                tint = color,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}