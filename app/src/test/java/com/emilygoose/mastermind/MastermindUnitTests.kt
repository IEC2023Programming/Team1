package com.emilygoose.mastermind

import junit.framework.TestCase.assertEquals
import org.junit.Test

class MastermindUnitTests {

    // Set variables for test environment
    private val secretCode = listOf(0, 5, 4, 3)
    private val viewModel = MainActivityViewModel()

    @Test
    fun guess_allBlack() {
        // Pass secret code for both to simulate entirely correct guess
        val resultPair = viewModel.getPegs(secretCode.toColors(), secretCode.toColors())
        assertEquals(resultPair, Pair(4, 0))
    }

    @Test
    fun guess_AllWhite() {
        // Guess that is the secret code but the wrong order
        val guess = secretCode.reversed()
        val resultPair = viewModel.getPegs(guess.toColors(), secretCode.toColors())
        assertEquals(resultPair, Pair(0, 4))
    }

    @Test
    fun guess_HalfHalf() {
        // Guess that is two black, two white
        val guess = secretCode.subList(0, 2) + secretCode.subList(2, 4).reversed()
        val resultPair = viewModel.getPegs(guess.toColors(), secretCode.toColors())
        assertEquals(resultPair, Pair(2, 2))
    }

    @Test
    fun guess_allWrong() {
        // Guess that is completely distinct from the secret code
        val guess = listOf(1, 1, 1, 1)
        val resultPair = viewModel.getPegs(guess.toColors(), secretCode.toColors())
        assertEquals(resultPair, Pair(0, 0))
    }
}