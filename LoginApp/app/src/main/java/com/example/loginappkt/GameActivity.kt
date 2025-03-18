package com.example.loginappkt

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.loginappkt.databinding.ActivityGameBinding
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding
    private lateinit var timerHandler: Handler
    private lateinit var timerRunnable: Runnable
    private var timeRemaining: Int = 30
    private var score: Int = 0
    private var isGameRunning: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the user's email from the intent
        val userEmail = intent.getStringExtra("USER_EMAIL") ?: "Player"
        binding.userLabel.text = userEmail

        // Set up the start button
        binding.startButton.setOnClickListener {
            startGame()
        }

        // Set up the ball button
        binding.ballButton.setOnClickListener {
            score++
            binding.scoreLabel.text = "Score: $score"
            moveBall()
        }
    }

    private fun startGame() {
        score = 0
        timeRemaining = 30
        isGameRunning = true

        binding.scoreLabel.text = "Score: $score"
        binding.timerLabel.text = "$timeRemaining"
        binding.ballButton.visibility = View.VISIBLE

        // Start the timer
        timerHandler = Handler(Looper.getMainLooper())
        timerRunnable = object : Runnable {
            override fun run() {
                if (timeRemaining > 0) {
                    timeRemaining--
                    binding.timerLabel.text = "$timeRemaining"
                    timerHandler.postDelayed(this, 1000)
                } else {
                    endGame()
                }
            }
        }
        timerHandler.post(timerRunnable)

        // Move the ball initially
        moveBall()
    }

    private fun moveBall() {
        val container = binding.gameContainer
        val ball = binding.ballButton

        val maxX = container.width - ball.width
        val maxY = container.height - ball.height

        val randomX = Random.nextInt(0, maxX)
        val randomY = Random.nextInt(0, maxY)

        ball.animate()
            .x(randomX.toFloat())
            .y(randomY.toFloat())
            .setDuration(200)
            .start()
    }

    private fun endGame() {
        isGameRunning = false
        timerHandler.removeCallbacks(timerRunnable)
        binding.ballButton.visibility = View.INVISIBLE

        // Show the game over dialog
        AlertDialog.Builder(this)
            .setTitle("Game Over")
            .setMessage("Final Score: $score")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .show()
    }

}