package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.LifeTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LifeTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    LifeTotalTracker()
                }
            }
        }
    }
}

@Composable
fun LifeTotalTracker() {
    var player1Life by remember { mutableStateOf(20) }
    var player2Life by remember { mutableStateOf(20) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Player 1 Life: $player1Life", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Button(onClick = { player1Life++ }) {
                Text(text = "+")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { player1Life-- }) {
                Text(text = "-")
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Player 2 Life: $player2Life", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Button(onClick = { player2Life++ }) {
                Text(text = "+")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { player2Life-- }) {
                Text(text = "-")
            }
        }
    }
}
