package com.example.myapplication.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

/**
 * A composable function that displays a life tracker for a player.
 *
 * @param playerName The name of the player.
 * @param playerLife The current life total of the player.
 * @param onIncrement A callback function that is invoked when the increment button is clicked.
 * @param onDecrement A callback function that is invoked when the decrement button is clicked.
 */
@Composable
fun PlayerLifeTracker(playerName: String, playerLife: Int, onIncrement: () -> Unit, onDecrement: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Display the player's name and current life total
        Text(text = "$playerName Life: $playerLife", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            // Button to decrement the player's life total
            Button(onClick = onDecrement) {Text(text = "-")}
            Spacer(modifier = Modifier.width(8.dp))
            // Button to increment the player's life total
            Button(onClick = onIncrement) {Text(text = "+")}
        }
    }
}