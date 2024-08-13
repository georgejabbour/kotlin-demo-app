package com.example.myapplication.ui

import androidx.compose.foundation.layout.*
import androidx.compose.ui.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * A dialog that prompts the user to select the starting life total for a new game.
 *
 * @param onStartGame A callback function that is invoked with the selected starting life total when the user starts the game.
 * @param onDismiss A callback function that is invoked when the dialog is dismissed.
 */
@Composable
fun NewGameDialog(onStartGame: (Int) -> Unit, onDismiss: () -> Unit) {
    // State to keep track of the selected starting life total option
    var selectedOption by remember { mutableIntStateOf(20) }

    Dialog(onDismissRequest = onDismiss) {
        Surface {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Display the title of the dialog
                Text(text = "Select Starting Life Total", style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(16.dp))
                // Display buttons for selecting the starting life total
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
                // Button to start the game with the selected starting life total
                Button(onClick = { onStartGame(selectedOption) }) {
                    Text(text = "Start Game")
                }
            }
        }
    }
}