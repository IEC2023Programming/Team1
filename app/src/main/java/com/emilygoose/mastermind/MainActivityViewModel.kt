package com.emilygoose.mastermind

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.emilygoose.mastermind.data.GuessColor

class MainActivityViewModel : ViewModel() {
    // Number of possible colors in the game
    private val COLOR_SET = 6

    // Set of guesses - mutableListOf maintains order
    val guesses = mutableStateListOf<List<GuessColor>>()

    // Current indices for the guess
    val currentGuess = mutableStateListOf(0, 0, 0, 0)

    // Secret code for the player to guess
    var secretCode: List<GuessColor>
        private set

    // Flag for if the user can enter a new guess
    var canGuess = mutableStateOf(true)
        private set

    init {
        // Generate the first secret code
        secretCode = generateSecret()
    }

    // Resets game state and all guesses
    fun resetGame() {
        // Reset current guess to default
        currentGuess.fill(0)
        // Remove all guesses from last game
        guesses.clear()
        // Generate a new secret code
        secretCode = generateSecret()
        // Allow guessing
        canGuess.value = true
    }

    // Increments the color in the guess selection row
    fun incrementGuess(index: Int) {
        val currentColor = currentGuess[index]
        // Increment current colour, wrap around if above max index for guess colors
        if (currentColor + 1 >= COLOR_SET) {
            Log.d("VM", "Incrementing index $index by 1, wrap to 0")
            currentGuess[index] = 0
        } else {
            Log.d("VM", "Incrementing index $index by 1, new value ${currentColor + 1}")
            currentGuess[index] = currentColor + 1
        }
    }

    // Submits a guess to list of current guesses
    fun submitGuess() {
        val currentGuessColors = currentGuess.toColors()
        // Add list to guesses
        guesses.add(
            currentGuessColors
        )
        // If game is won or if too many guesses, disable guessing
        if (guesses.size >= 10 || currentGuessColors == secretCode) {
            canGuess.value = false
        }
    }

    // Gets the black/white pegs for a given guess
    // secret is optional defaulting to secretCode so we can pass manually for unit testing
    fun getPegs(guess: List<GuessColor>, secret: List<GuessColor> = secretCode): Pair<Int, Int> {
        var black = 0
        var white = 0
        val guessed = mutableListOf<GuessColor>()
        // Iterate over the guess
        for (index in guess.indices) {
            // Check for exact hit
            if (guess[index] == secret[index]) {
                // Exact hit - Increment black
                black ++
                // If we've seen this color already remove the inexact match
                if (guessed.contains(guess[index])) {
                    white --
                } else {
                    guessed.add(guess[index])
                }
            } else if (secret.contains(guess[index])) {
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

    // Randomly generates a secret code
    fun generateSecret(): List<GuessColor> {
        val guessList = GuessColor.values()
            .toList()
            .subList(0,COLOR_SET) // Take sublist of only first n colors
            .shuffled()
        return guessList.subList(0, 4)
    }
}
