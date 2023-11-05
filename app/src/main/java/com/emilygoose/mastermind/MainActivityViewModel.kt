package com.emilygoose.mastermind

import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    // Set of guesses - mutableListOf maintains order
    val guesses = mutableListOf<List<GuessColor>>()

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
}