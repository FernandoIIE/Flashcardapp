package com.example.flashcardsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referências aos elementos do layout
        val welcomeTitle = findViewById<TextView>(R.id.welcomeTitle)
        val welcomeDesc = findViewById<TextView>(R.id.welcomeDesc)
        val startBtn = findViewById<Button>(R.id.startBtn)

        // Texto do título e descrição
        welcomeTitle.text = "Welcome!"
        welcomeDesc.text = "Practice your knowledge with fun flashcards! Answer the questions and test yourself."

        // Quando o botão for clicado, abre a tela de perguntas
        startBtn.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
        }
    }
}
