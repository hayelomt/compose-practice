package com.example.composeapplication.src.game.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeapplication.src.game.Poker

@Composable
fun GameBody(
    lastDrawnCards: List<Poker>
) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row() {
            Text("Head")
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CardBack()

            Box(modifier = Modifier.fillMaxWidth(0.9f)) {
                CardListing(
                    cards = lastDrawnCards
                )
            }
        }
        Row() {
            Text(text = "Buttons")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGameBody() {
    Box(modifier = Modifier.fillMaxHeight(0.8f)) {
        GameBody(
            lastDrawnCards = listOf(
                Poker(title = "Club 1", identifier = "club_1", expanded = false),
                Poker(title = "Club 2", identifier = "club_2", expanded = false),
                Poker(title = "Club 3", identifier = "club_3", expanded = false),
                Poker(title = "Joker 2", identifier = "joker_2", expanded = false),
                Poker(title = "Heart King", identifier = "heart_king", expanded = false),
                Poker(title = "Club 1", identifier = "club_1", expanded = false),
                Poker(title = "Club 2", identifier = "club_2", expanded = false),
                Poker(title = "Club 3", identifier = "club_3", expanded = false),
                Poker(title = "Joker 2", identifier = "joker_2", expanded = false),
                Poker(title = "Heart King", identifier = "heart_king", expanded = false),
                Poker(title = "Club 1", identifier = "club_1", expanded = false),
                Poker(title = "Club 2", identifier = "club_2", expanded = false),
                Poker(title = "Club 3", identifier = "club_3", expanded = false),
                Poker(title = "Joker 2", identifier = "joker_2", expanded = false),
                Poker(title = "Heart King", identifier = "heart_king", expanded = false),
                Poker(title = "Club 1", identifier = "club_1", expanded = false),
                Poker(title = "Club 2", identifier = "club_2", expanded = false),
                Poker(title = "Club 3", identifier = "club_3", expanded = false),
                Poker(title = "Joker 2", identifier = "joker_2", expanded = false),
                Poker(title = "Heart King", identifier = "heart_king", expanded = false),
                Poker(title = "Club 1", identifier = "club_1", expanded = false),
                Poker(title = "Club 2", identifier = "club_2", expanded = false),
                Poker(title = "Club 3", identifier = "club_3", expanded = false),
                Poker(title = "Joker 2", identifier = "joker_2", expanded = false),
                Poker(title = "Heart King", identifier = "heart_king", expanded = false),
                Poker(title = "Diamond 10", identifier = "diamond_10", expanded = true),
            )
        )
    }
}