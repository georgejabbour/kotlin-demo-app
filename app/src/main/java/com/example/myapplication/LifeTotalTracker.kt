package com.example.myapplication.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * A composable function that displays the life totals for two players and provides controls to increment, decrement, and reset the life totals.
 *
 * @param startingLife The initial life total for both players.
 */
@Composable
fun LifeTotalTracker(startingLife: Int) {
    // State variables to keep track of the life totals for both players
    var player1Life by remember { mutableIntStateOf(startingLife) }
    var player2Life by remember { mutableIntStateOf(startingLife) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Display the life tracker for Player 1
        PlayerLifeTracker(
            playerName = "Player 1",
            playerLife = player1Life,
            onIncrement = { player1Life++ },
            onDecrement = { player1Life-- }
        )
        Spacer(modifier = Modifier.height(32.dp))
        // Display the life tracker for Player 2
        PlayerLifeTracker(
            playerName = "Player 2",
            playerLife = player2Life,
            onIncrement = { player2Life++ },
            onDecrement = { player2Life-- }
        )
        Spacer(modifier = Modifier.height(32.dp))
        // Button to reset the life totals for both players to the starting life total
        Button(onClick = {
            player1Life = startingLife
            player2Life = startingLife
        }) {
            Text(text = "Reset")
        }
    }
}