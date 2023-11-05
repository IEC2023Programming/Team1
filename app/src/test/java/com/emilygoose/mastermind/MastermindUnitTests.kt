package com.emilygoose.mastermind

import junit.framework.TestCase.assertEquals
import org.junit.Test

class MastermindUnitTests {

    // Set variables for test environment
    private val secretCode = listOf(1, 4, 2, 3)
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
        val guess = listOf(0, 0, 0, 0)
        val resultPair = viewModel.getPegs(guess.toColors(), secretCode.toColors())
        assertEquals(resultPair, Pair(0, 0))
    }

    @Test
    fun given_One() {
        val guess = listOf(5, 6, 7, 8)
        val resultPair = viewModel.getPegs(guess.toColors(), secretCode.toColors())
        assertEquals(resultPair, Pair(0, 0))
    }

    @Test
    fun given_Two() {
        val guess = listOf(2, 2, 2, 2)
        val resultPair = viewModel.getPegs(guess.toColors(), secretCode.toColors())
        assertEquals(resultPair, Pair(1, 0))
    }

    @Test
    fun given_Three() {
        val guess = listOf(1, 2, 3, 4)
        val resultPair = viewModel.getPegs(guess.toColors(), secretCode.toColors())
        assertEquals(resultPair, Pair(1, 3))
    }

    @Test
    fun given_Four() {
        val guess = listOf(2, 2, 1, 1)
        val resultPair = viewModel.getPegs(guess.toColors(), secretCode.toColors())
        assertEquals(resultPair, Pair(0, 2))
    }
}