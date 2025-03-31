package com.example.kotlinbasics

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculatorActivity : AppCompatActivity() {

    private lateinit var number1EditText: EditText
    private lateinit var number2EditText: EditText
    private lateinit var sumButton: Button
    private lateinit var deleteButton: Button
    private lateinit var showSumTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculator)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        number1EditText = findViewById(R.id.number1EditText)
        number2EditText = findViewById(R.id.number2EditText)
        sumButton = findViewById(R.id.sumButton)
        deleteButton = findViewById(R.id.deleteButton)
        showSumTextView = findViewById(R.id.showSumTextView)



        sumButton.setOnClickListener(){
            val numberToString = number1EditText.text.toString()
            val number1 = numberToString.toInt()
            val numberToString2 = number2EditText.text.toString()
            val number2 = numberToString2.toInt()

            showSumTextView.text = "Eredmény: " + Integer.valueOf(number1+number2)
        }


        deleteButton.setOnClickListener(){
            number1EditText.text.clear()
            number2EditText.text.clear()
            showSumTextView.text = "Eredmény: -"
        }
    }
}