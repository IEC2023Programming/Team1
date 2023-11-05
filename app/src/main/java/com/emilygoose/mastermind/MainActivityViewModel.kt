package com.emilygoose.mastermind

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    // Set of guesses - mutableListOf maintains order
    val guesses = mutableStateListOf<List<GuessColor>>()
    var guessCount = 0

    // Current indices for the guess
    val currentGuess = mutableStateListOf(0, 0, 0, 0)

    fun incrementGuess(index: Int) {
        val currentColor = currentGuess[index]
        // Increment current colour, wrap around if above max index for guess colors
        if (currentColor + 1 >= GuessColor.values().size) {
            Log.d("VM", "Incrementing index $index by 1, wrap to 0")
            currentGuess[index] = 0
        } else {
            Log.d("VM", "Incrementing index $index by 1, new value ${currentColor + 1}")
            currentGuess[index] = currentColor + 1
        }
    }

    fun submitGuess() {
        // Add list to guesses
        guesses.add(
            currentGuess.map { index ->
                GuessColor.values()[index]
            }
        )
    }

    private val secretCode: List<GuessColor> = listOf(GuessColor.RED, GuessColor.GREEN, GuessColor.BLUE, GuessColor.CYAN)

    fun getPegs(guess: List<GuessColor>): Pair<Int, Int> {
        var black = 0
        var white = 0
        val guessed = mutableListOf<GuessColor>()
        // Iterate over the guess
        for (index in guess.indices) {
            // Check for exact hit
            if (guess[index] == secretCode[index]) {
                // Exact hit - Increment black
                black ++
                // If we've seen this color already remove the inexact match
                if (guessed.contains(guess[index])) {
                    white --
                } else {
                    guessed.add(guess[index])
                }
            } else if (secretCode.contains(guess[index])) {
                // Make sure we haven't exact matched this color before
                if (!guessed.contains(guess[index])) {
                    // Match somewhere - Increment white
                    white++
                    guessed.add(guess[index])
                }
            }
        }
        // Pair[0] = Black, Pair[1] = White
        return Pair(black, white)
    }

    fun generate_guess(): List<GuessColor> {
        val guessList = GuessColor.values().toList().shuffled()
        return guessList.subList(0, 3)
    }
}