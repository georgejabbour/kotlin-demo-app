package com.example.myapplication.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

@Composable
fun PlayerLifeTracker(playerName: String, playerLife: Int, onIncrement: () -> Unit, onDecrement: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "$playerName Life: $playerLife", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Button(onClick = onIncrement) {
                Text(text = "+")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = onDecrement) {
                Text(text = "-")
            }
        }
    }
}