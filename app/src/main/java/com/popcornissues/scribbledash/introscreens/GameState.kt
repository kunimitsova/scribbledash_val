package com.popcornissues.scribbledash.introscreens

data class GameState (
    val game: Game? = null,
    val difficulty: Difficulty? = null,
    val gameScore: Int = 0
)

enum class Game {
    OneRoundWonder,
    game2,
    game3
}

enum class Difficulty {
    Beginner,
    Challenging,
    Master
}
