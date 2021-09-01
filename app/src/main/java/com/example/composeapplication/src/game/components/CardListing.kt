package com.example.composeapplication.src.game.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapplication.src.game.Poker
import com.example.composeapplication.src.game.utils.getPokerDrawable

@Composable
fun CardListing(cards: List<Poker>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 15.dp)
            .border(BorderStroke(1.dp, Color.Black)),
        contentAlignment = Alignment.BottomStart
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(cards) { card ->
                PokerCard(pokerDrawable = getPokerDrawable(card), expanded = card.expanded)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCardListing() {
    CardListing(
        cards = listOf(
            Poker(title = "Club 1", identifier = "club_1", expanded = true),
            Poker(title = "Club 2", identifier = "club_2", expanded = false),
            Poker(title = "Club 3", identifier = "club_3", expanded = false),
            Poker(title = "Joker 2", identifier = "joker_2", expanded = true),
            Poker(title = "Heart King", identifier = "heart_king", expanded = false),
            Poker(title = "Diamond 10", identifier = "diamond_10", expanded = false)
        )
    )
}
