package com.emilygoose.mastermind

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.emilygoose.mastermind.ui.GuessRow
import com.emilygoose.mastermind.ui.ResultAlertDialog
import com.emilygoose.mastermind.ui.theme.MastermindTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: MainActivityViewModel by viewModels()

        setContent {
            MastermindTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            OutlinedCard(
                                modifier = Modifier
                                    .height(640.dp)
                                    .width(352.dp)
                            ) {
                                for (guess in viewModel.guesses) {
                                    GuessRow(
                                        guess = guess,
                                        pegs = viewModel.getPegs(guess),
                                        locked = true
                                    )
                                }
                            }
                            // Show unlocked guessable row if allowed to guess
                            if (viewModel.canGuess.value) {
                                GuessRow(
                                    guess =
                                    // Map indices from the mutableList to colors
                                    viewModel.currentGuess.toColors(),
                                    locked = false,
                                    // Callback to increment guess colors on click
                                    onColorClick = { index ->
                                        viewModel.incrementGuessColor(index)
                                    },
                                    // Callback for when submit button is clicked
                                    onSubmit = {
                                        viewModel.submitGuess()
                                    }
                                )
                            } else {
                                // Show the user the actual answer if they've reached max guesses or won
                                GuessRow(guess = viewModel.secretCode, locked = true)
                            }
                        }
                    }
                }
                when {
                    !viewModel.canGuess.value -> {
                        // Show alert dialog when the game is done
                        ResultAlertDialog(
                            onConfirmation = { viewModel.resetGame() },
                            isWinner = viewModel.isWinner.value
                        )
                    }
                }
            }
        }
    }
}