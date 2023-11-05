package com.emilygoose.mastermind.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Celebration
import androidx.compose.material.icons.filled.SentimentVeryDissatisfied
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.emilygoose.mastermind.R

@Composable
fun ResultAlertDialog(
    onConfirmation: () -> Unit,
    isWinner: Boolean,
) {
    // Pick icon and text based on if we've won
    val icon = if (isWinner) Icons.Filled.Celebration else Icons.Filled.SentimentVeryDissatisfied
    val dialogTitle = if (isWinner) stringResource(R.string.winner_title) else stringResource(R.string.loser_title)
    val dialogText = if (isWinner) stringResource(R.string.winner_body) else stringResource(R.string.loser_body)
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Alert Dialog Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = { },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Restart")
            }
        }
    )
}