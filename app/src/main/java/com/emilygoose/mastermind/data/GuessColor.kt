package com.emilygoose.mastermind.data

import androidx.compose.ui.graphics.Color

enum class GuessColor(val color: Color) {
    RED(Color.Red),
    BLUE(Color.Blue),
    GREEN(Color.Green),
    PURPLE(Color.Magenta),
    YELLOW(Color.Yellow),
    CYAN(Color.Cyan),
    FOREST(Color.hsl(154F, 1F, 0.15F)),
    BYZANTINE(Color.hsl(309F, 0.77F, 0.40F)),
    PINK(Color.hsl(338F, 0.87F, 0.67F)),
    ORANGE(Color.hsl(22F, 0.98F, 0.49F))
}