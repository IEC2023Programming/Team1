package com.emilygoose.mastermind

import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    // Set of guesses - mutableListOf maintains order
    val guesses = mutableListOf<List<GuessColor>>()
    var guessCount = 0

    // MutableState of current guess (Use indices so we can increment)
    val currentGuessIndices = mutableListOf(0, 0, 0, 0)

    init {
        guesses.add(listOf(GuessColor.RED, GuessColor.BLUE, GuessColor.CYAN, GuessColor.PURPLE))
        guesses.add(listOf(GuessColor.YELLOW, GuessColor.RED, GuessColor.CYAN, GuessColor.PURPLE))
        guesses.add(listOf(GuessColor.GREEN, GuessColor.YELLOW, GuessColor.PURPLE, GuessColor.CYAN))
        guesses.add(listOf(GuessColor.GREEN, GuessColor.YELLOW, GuessColor.PURPLE, GuessColor.CYAN))
        guesses.add(listOf(GuessColor.GREEN, GuessColor.YELLOW, GuessColor.PURPLE, GuessColor.CYAN))
        guesses.add(listOf(GuessColor.GREEN, GuessColor.YELLOW, GuessColor.PURPLE, GuessColor.CYAN))
        guesses.add(listOf(GuessColor.GREEN, GuessColor.YELLOW, GuessColor.PURPLE, GuessColor.CYAN))
        guesses.add(listOf(GuessColor.GREEN, GuessColor.YELLOW, GuessColor.PURPLE, GuessColor.CYAN))
    }

    fun incrementGuess(index: Int) {
        val currentColor = currentGuessIndices[index]
        // Increment current colour, wrap around if above max index for guess colors
        if (currentColor + 1 >= GuessColor.values().size) {
            currentGuessIndices[index] = 0
        } else {
            currentGuessIndices[index] = currentColor + 1
        }
    }

    val secretCode: List<Color>? = null
    fun guess_score(guess: MutableList<Color>): Pair<Int, Int> {
        if (secretCode == null) {
            Log.e("fun: guess_secret", "Secret is null")
            return Pair(-1, -1)
        }
        var tempSecret=secretCode.toMutableList()
        var black = 0
        var white = 0
        //If index and colour match - increment black by one and set given colour to unspecified
        for (i in 0..guess.size) {
            if (guess[i] == tempSecret[i]) {
                black++
                tempSecret[i] = Color.Unspecified
            }
        }

        //If colour is found - increment white by one and set given colour to unspecified
        for (i in 0..guess.size) {
            if (tempSecret.indexOf(guess[i]) != -1) {
                white++
                tempSecret[tempSecret.indexOf(guess[i])]=Color.Unspecified
            }
        }
        guessCount++
        return Pair(black, white)
    }
}