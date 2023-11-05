package com.emilygoose.mastermind

import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    // Set of guesses - mutableListOf maintains order
    val guesses = mutableListOf<List<GuessColor>>()

    init {
        guesses.add(listOf(GuessColor.RED, GuessColor.BLUE, GuessColor.CYAN, GuessColor.PURPLE))
        guesses.add(listOf(GuessColor.YELLOW, GuessColor.RED, GuessColor.CYAN, GuessColor.PURPLE))
        guesses.add(listOf(GuessColor.GREEN, GuessColor.YELLOW, GuessColor.PURPLE, GuessColor.CYAN))
        guesses.add(listOf(GuessColor.GREEN, GuessColor.YELLOW, GuessColor.PURPLE, GuessColor.CYAN))
        guesses.add(listOf(GuessColor.GREEN, GuessColor.YELLOW, GuessColor.PURPLE, GuessColor.CYAN))
        guesses.add(listOf(GuessColor.GREEN, GuessColor.YELLOW, GuessColor.PURPLE, GuessColor.CYAN))
        guesses.add(listOf(GuessColor.GREEN, GuessColor.YELLOW, GuessColor.PURPLE, GuessColor.CYAN))
        guesses.add(listOf(GuessColor.GREEN, GuessColor.YELLOW, GuessColor.PURPLE, GuessColor.CYAN))
        guesses.add(listOf(GuessColor.GREEN, GuessColor.YELLOW, GuessColor.PURPLE, GuessColor.CYAN))
        guesses.add(listOf(GuessColor.GREEN, GuessColor.YELLOW, GuessColor.PURPLE, GuessColor.CYAN))
    }
}