package com.example.flashcardsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)
        val questions = intent.getStringArrayListExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")
        val userAnswers = intent.getBooleanArrayExtra("userAnswers")

        val scoreText = findViewById<TextView>(R.id.scoreText)
        val feedbackText = findViewById<TextView>(R.id.feedbackText)
        val reviewText = findViewById<TextView>(R.id.reviewText)
        val reviewBtn = findViewById<Button>(R.id.reviewBtn)
        val restartBtn = findViewById<Button>(R.id.restartBtn)

        scoreText.text = "Score: $score/$total"
        feedbackText.text = if (score >= total / 2) "Great Job!" else "Keep Practising!"

        reviewBtn.setOnClickListener {
            val sb = StringBuilder()
            if (questions != null && answers != null && userAnswers != null) {
                for (i in questions.indices) {
                    sb.append("${i+1}. ${questions[i]}\n")
                    sb.append("Correct Answer: ${answers[i]}\n")
                    sb.append("Your Answer: ${userAnswers[i]}\n\n")
                }
            }
            reviewText.text = sb.toString()
        }

        restartBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
