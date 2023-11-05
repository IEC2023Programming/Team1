package com.emilygoose.mastermind.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.emilygoose.mastermind.ui.theme.ColorDot

@Composable
fun GuessResult(pegs: Pair<Int, Int>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .size(64.dp)
            .padding(8.dp),

    ) {
        // Draw black pegs first
        items(pegs.first) {
            ColorDot(
                color = Color.DarkGray,
                modifier = Modifier
                    .size(24.dp)
                    .padding(4.dp),
                onClick = {}
            )
        }
        // Draw white pegs second
        items(pegs.second) {
            ColorDot(
                color = Color.LightGray,
                modifier = Modifier
                    .size(24.dp)
                    .padding(4.dp),
                onClick = {}
            )
        }
    }
}


