package com.emilygoose.mastermind.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.emilygoose.mastermind.GuessColor

@Composable
fun GuessRow(guess: List<GuessColor>) {
    Row(
        modifier = Modifier.height(64.dp)
    ) {
        ColorRow(guess)
    }
}