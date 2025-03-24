package com.example.loginappcompose

import android.app.AlertDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import kotlin.random.Random
import kotlinx.coroutines.delay

@Composable
fun GameScreen(email: String) {
    var score by remember { mutableIntStateOf(0) }
    var timeRemaining by remember { mutableIntStateOf(30) }
    var ballPosition by remember { mutableStateOf(Offset.Zero) }
    var isGameRunning by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var containerSize by remember { mutableStateOf(IntSize.Zero) }
    val density = LocalDensity.current
    val ballSizePx = with(density) { 60.dp.roundToPx() }

    fun moveBall() {
        if (containerSize.width > ballSizePx && containerSize.height > ballSizePx) {
            ballPosition = Offset(
                Random.nextInt(0, containerSize.width - ballSizePx).toFloat(),
                Random.nextInt(0, containerSize.height - ballSizePx).toFloat()
            )
        }
    }

    LaunchedEffect(isGameRunning, timeRemaining) {
        if (isGameRunning && timeRemaining > 0) {
            delay(1000)
            timeRemaining--
        } else if (timeRemaining == 0 && isGameRunning) {
            isGameRunning = false
            AlertDialog.Builder(context)
                .setTitle("Game Over")
                .setMessage("Final Score: $score")
                .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Player: $email", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Time: $timeRemaining", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Score: $score", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .background(Color.LightGray.copy(alpha = 0.3f))
                .onSizeChanged { containerSize = it }
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .offset { IntOffset(ballPosition.x.toInt(), ballPosition.y.toInt()) }
                    .clip(CircleShape)
                    .background(Color.Red)
                    .clickable(enabled = isGameRunning) {
                        score++
                        moveBall()
                    }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                score = 0
                timeRemaining = 30
                isGameRunning = true
                moveBall()
            },
            enabled = !isGameRunning
        ) {
            Text(if (isGameRunning) "Game Running" else "Start Game")
        }
    }
}


