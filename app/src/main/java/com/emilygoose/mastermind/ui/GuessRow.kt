package com.emilygoose.mastermind.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.TaskAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.emilygoose.mastermind.data.GuessColor

@Composable
fun GuessRow(
    guess: List<GuessColor>, // Guess to display in the row
    locked: Boolean, // Whether the row is locked - Unlocked row is editable to guess
    pegs: Pair<Int, Int> = Pair(0,0), // Pegs to display with a locked guess
    onColorClick: (Int) -> Unit = {}, // Callback for color being clicked
    onSubmit: () -> Unit = {} // Callback for guess being submitted
) {
    Row(
        modifier = Modifier.height(64.dp)
    ) {
        ColorRow(
            guess,
            onColorClick = { index ->
                // If the row is not locked pass the click up the function
                if (!locked) {
                    onColorClick(index)
                }
            }
        )
        // If locked - Display result
        // If not locked - Display submit button
        if (locked) {
            GuessResult(pegs)
        } else {
            IconButton(
                onClick = onSubmit,
                modifier = Modifier.size(64.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.TaskAlt,
                    contentDescription = "Submit guess"
                )
            }
        }
    }
}