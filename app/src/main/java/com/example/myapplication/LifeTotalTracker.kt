package com.example.myapplication.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * A composable function that displays the life totals for multiple players and provides controls to increment, decrement, and reset the life totals.
 *
 * @param startingLife The initial life total for all players.
 * @param numPlayers The number of players in the game.
 */
@Composable
fun LifeTotalTracker(startingLife: Int, numPlayers: Int) {
    // State to keep track of the life totals for all players
    val playerLives = remember { mutableStateListOf<Int>() }

    // Initialize or reset the playerLives list based on the number of players
    LaunchedEffect(numPlayers) {
        playerLives.clear()
        repeat(numPlayers) {
            playerLives.add(startingLife)
        }
    }

    // State to control the visibility of the NewGameDialog
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Display the life totals for each player
        playerLives.forEachIndexed { index, life ->
            PlayerLifeTracker(
                playerName = "Player ${index + 1}",
                playerLife = life,
                onIncrement = { playerLives[index]++ },
                onDecrement = { playerLives[index]-- }
            )
            Spacer(modifier = Modifier.height(32.dp))
        }

        Spacer(modifier = Modifier.height(32.dp))
        // Button to show the NewGameDialog
        Button(onClick = { showDialog = true }) {
            Text(text = "Reset")
        }
    }

    // Show the NewGameDialog if showDialog is true
    if (showDialog) {
        NewGameDialog(
            onStartGame = { life, num ->
                playerLives.clear()
                repeat(num) {
                    playerLives.add(life)
                }
                showDialog = false
            },
            onDismiss = { showDialog = false }
        )
    }
}