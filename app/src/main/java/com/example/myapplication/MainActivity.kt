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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LifeTrackerTheme {
                var showDialog by remember { mutableStateOf(true) }
                var startingLife by remember { mutableStateOf(20) }

                if (showDialog) {
                    NewGameDialog(
                        onStartGame = { life ->
                            startingLife = life
                            showDialog = false
                        },
                        onDismiss = { showDialog = false }
                    )
                } else {
                    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                        LifeTotalTracker(startingLife = startingLife)
                    }
                }
            }
        }
    }
}