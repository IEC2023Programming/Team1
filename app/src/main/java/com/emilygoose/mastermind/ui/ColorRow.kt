package com.emilygoose.mastermind.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.emilygoose.mastermind.GuessColor
import com.emilygoose.mastermind.ui.theme.ColorDot

@Composable
fun ColorRow(
    colors: List<GuessColor>,
    onColorClick: (Int) -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        for (index in colors.indices) {
            ColorDot(
                color = colors[index].color,
                modifier = Modifier
                    .size(64.dp)
                    .padding(8.dp),
                onClick = {
                    // Click event with index
                    onColorClick(index)
                }
            )
        }
    }
}

@Preview
@Composable
fun ColorRowPreview() {
    ColorRow(colors = listOf(GuessColor.RED, GuessColor.BLUE, GuessColor.CYAN, GuessColor.PURPLE))
}