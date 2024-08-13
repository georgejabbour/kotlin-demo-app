package com.example.myapplication.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LifeTotalTracker() {
    var player1Life by remember { mutableIntStateOf(20) }
    var player2Life by remember { mutableIntStateOf(20) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PlayerLifeTracker(
            playerName = "Player 1",
            playerLife = player1Life,
            onIncrement = { player1Life++ },
            onDecrement = { player1Life-- }
        )
        Spacer(modifier = Modifier.height(32.dp))
        PlayerLifeTracker(
            playerName = "Player 2",
            playerLife = player2Life,
            onIncrement = { player2Life++ },
            onDecrement = { player2Life-- }
        )
    }
}