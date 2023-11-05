package com.emilygoose.mastermind.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.emilygoose.mastermind.ui.theme.ColorDot

@Preview
@Composable
fun ColorRow() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        for (i in 1..4) {
            ColorDot(
                color = Color.Cyan,
                modifier = Modifier
                    .size(64.dp)
                    .padding(8.dp)
            )
        }
    }
}
