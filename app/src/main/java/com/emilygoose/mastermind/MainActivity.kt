package com.emilygoose.mastermind

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.emilygoose.mastermind.ui.GuessRow
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
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        for (guess in viewModel.guesses) {
                            GuessRow(guess, true)
                        }
                        GuessRow(
                            guess =
                            // Map indices from the mutableList to colors
                            viewModel.currentGuess.map { index ->
                                GuessColor.values()[index]
                            },
                            locked = false,
                            onColorClick = { index ->
                                viewModel.incrementGuess(index)
                            },
                            onSubmit = {
                                viewModel.submitGuess()
                            }
                        )
                    }
                }
            }
        }
    }
}