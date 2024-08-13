package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import com.example.myapplication.ui.theme.LifeTrackerTheme
import com.example.myapplication.ui.LifeTotalTracker
import com.example.myapplication.ui.NewGameDialog
import androidx.compose.ui.Modifier

/**
 * MainActivity is the entry point of the application.
 * It sets up the UI and handles the logic for starting a new game and resetting life totals.
 */
class MainActivity : ComponentActivity() {
    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LifeTrackerTheme {
                // State to control the visibility of the NewGameDialog
                var showDialog by remember { mutableStateOf(true) }
                // State to store the starting life total for the game
                var startingLife by remember { mutableIntStateOf(20) }

                // Show the NewGameDialog if showDialog is true
                if (showDialog) {
                    NewGameDialog(
                        onStartGame = { life ->
                            startingLife = life
                            showDialog = false
                        },
                        onDismiss = { showDialog = false }
                    )
                } else {
                    // Display the LifeTotalTracker with the selected starting life total
                    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                        LifeTotalTracker(startingLife = startingLife)
                    }
                }
            }
        }
    }
}