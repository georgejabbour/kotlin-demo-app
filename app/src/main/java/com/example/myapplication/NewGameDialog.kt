package com.example.myapplication.ui

import androidx.compose.foundation.layout.*
import androidx.compose.ui.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NewGameDialog(onStartGame: (Int) -> Unit, onDismiss: () -> Unit) {
    var selectedOption by remember { mutableStateOf(20) }

    Dialog(onDismissRequest = onDismiss) {
        Surface {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Select Starting Life Total", style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Button(onClick = { selectedOption = 20 }) {
                        Text(text = "20")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = { selectedOption = 40 }) {
                        Text(text = "40")
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { onStartGame(selectedOption) }) {
                    Text(text = "Start Game")
                }
            }
        }
    }
}