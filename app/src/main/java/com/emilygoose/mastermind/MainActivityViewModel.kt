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

//    fun guess_score(guess: MutableList<Color>): Pair<Int, Int> {
//        if (secretCode == null) {
//            Log.e("fun: guess_secret", "Secret is null")
//            return Pair(-1, -1)
//        }
//        var tempSecret=secretCode.toMutableList()
//        var black = 0
//        var white = 0
//        //If index and colour match - increment black by one and set given colour to unspecified
//        for (i in 0..guess.size) {
//            if (guess[i] == tempSecret[i]) {
//                black++
//                tempSecret[i] = Color.Unspecified
//            }
//        }
//
//        //If colour is found - increment white by one and set given colour to unspecified
//        for (i in 0..guess.size) {
//            if (tempSecret.indexOf(guess[i]) != -1) {
//                white++
//                tempSecret[tempSecret.indexOf(guess[i])]=Color.Unspecified
//            }
//        }
//        guessCount++
//        return Pair(black, white)
//    }
}