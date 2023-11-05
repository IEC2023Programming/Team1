package com.emilygoose.mastermind.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.emilygoose.mastermind.GuessColor

@Preview
@Composable
fun GuessGrid() {
    Column {
        for (i in 0..64) {
            ColorRow(listOf(GuessColor.RED, GuessColor.BLUE, GuessColor.CYAN, GuessColor.PURPLE))

        }
    }
    Column {
        for (i in 0..64) {
            GuessResult()
        }
    }
}
