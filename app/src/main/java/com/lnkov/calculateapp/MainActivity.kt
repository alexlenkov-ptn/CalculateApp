package com.lnkov.calculateapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

const val untilNumber = 10
const val fromNumber = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textViewExample: TextView = findViewById(R.id.textViewExample)
        val editTextAnswer: EditText = findViewById(R.id.editTextAnswer)
        val buttonAnswer: Button = findViewById(R.id.buttonAnswer)
        val textIncorrectAnswer: TextView = findViewById(R.id.textIncorrectAnswer)
        val textCorrectAnswer: TextView = findViewById(R.id.textCorrectAnswer)


        val firstNumber: Int = Random.nextInt(fromNumber, untilNumber)
        val secondNumber: Int = Random.nextInt(fromNumber, untilNumber)
        val result = firstNumber + secondNumber

        textViewExample.setText("$firstNumber + $secondNumber = ?")

        // Слушатель клика
        buttonAnswer.setOnClickListener {
            val text: String = editTextAnswer.text.toString()
            if (text == result.toString()) {
                textCorrectAnswer.visibility = View.VISIBLE
                textIncorrectAnswer.visibility = View.GONE
            } else {
                textIncorrectAnswer.visibility = View.VISIBLE
                textCorrectAnswer.visibility = View.GONE
            }
        }


    }
}