package com.example.flashcardsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuestionActivity : AppCompatActivity() {

    private val questions = arrayListOf(
        "Is the Earth round?",
        "Is 20 + 20 = 40?",
        "Is water dry?"
    )
    private val answers = booleanArrayOf(true, true, false)
    private var currentIndex = 0
    private var score = 0
    private val userAnswers = BooleanArray(questions.size)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val questionText = findViewById<TextView>(R.id.questionText)
        val trueBtn = findViewById<Button>(R.id.trueBtn)
        val falseBtn = findViewById<Button>(R.id.falseBtn)
        val nextBtn = findViewById<Button>(R.id.nextBtn)
        val feedbackText = findViewById<TextView>(R.id.feedbackText1)
        questionText.text = questions[currentIndex]
        feedbackText.text = ""

        var answerSelected: Boolean? = null

        trueBtn.setOnClickListener {
            answerSelected = true
            feedbackText.text = if (answers[currentIndex]) "Correct!" else "Wrong!"
        }
        falseBtn.setOnClickListener {
            answerSelected = false
            feedbackText.text = if (!answers[currentIndex]) "Correct!" else "Wrong!"
        }

        nextBtn.setOnClickListener {
            if (answerSelected == null) {
                Toast.makeText(this, "Select an answer first!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Atualizar score e armazenar resposta do usuário
            userAnswers[currentIndex] = answerSelected!!
            if (answerSelected == answers[currentIndex]) score++

            currentIndex++
            answerSelected = null
            feedbackText.text = ""

            if (currentIndex < questions.size) {
                questionText.text = questions[currentIndex]
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", questions.size)
                intent.putStringArrayListExtra("questions", questions)
                intent.putExtra("answers", answers)
                intent.putExtra("userAnswers", userAnswers)
                startActivity(intent)
                finish()
            }
        }
    }
}
