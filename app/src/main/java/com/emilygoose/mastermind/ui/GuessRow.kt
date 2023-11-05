package com.emilygoose.mastermind.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.emilygoose.mastermind.GuessColor

@Composable
fun GuessRow(
    guess: List<GuessColor>,
    locked: Boolean,
    onColorClick: (Int) -> Unit = {},
    onSubmit: () -> Unit = {}
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
            // TODO Guess and check thingies
        } else {
            IconButton(
                onClick = onSubmit,
                modifier = Modifier.size(64.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.QuestionMark,
                    contentDescription = "Submit guess"
                )
            }
        }
    }
}