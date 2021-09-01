package com.example.composeapplication.src.game

import androidx.annotation.DrawableRes


data class Poker(
    val title: String,
    val identifier: String,
    val expanded: Boolean = false
)

data class PokerDrawable(
    @DrawableRes val cardId: Int,
    @DrawableRes val cardSideId: Int,
)