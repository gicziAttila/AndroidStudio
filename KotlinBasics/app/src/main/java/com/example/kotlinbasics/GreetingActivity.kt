package com.example.kotlinbasics

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class GreetingActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var greetingButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.greeting_activity)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        //Ui elemek inicializálása
        nameEditText = findViewById(R.id.nameEditText)
        greetingButton = findViewById(R.id.greetinButton)
        resultTextView = findViewById(R.id.resultTextView)

        greetingButton.setOnClickListener(){
            val name = nameEditText.text
            if(name.isNotEmpty()){
                val greetingText = when {
                    name.length <= 3 -> "Szia " + name + ", túl rövid a neved"
                    name.length >= 10 -> "Szia " + name + ", túl hosszú a neved"
                    else -> "Szia " + name
                }
                //eredmény kiiratása
                resultTextView.text = greetingText

                //billentyűzet eltüntetése
                try {
                    val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
                } catch (e: Exception) {
                    error("Nincs billentyűzet")
                }

                nameEditText.text.clear()

            }
            else{
                //hiba üzenet megjelenítése
                Toast.makeText(this, "Adj meg nevet!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}