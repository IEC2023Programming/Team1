package com.emilygoose.mastermind

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.emilygoose.mastermind.data.GuessColor

fun SnapshotStateList<Int>.toColors(): List<GuessColor> {
    return this.map { index ->
        GuessColor.values()[index]
    }
}

fun List<Int>.toColors(): List<GuessColor> {
    return this.map { index ->
        GuessColor.values()[index]
    }
}
