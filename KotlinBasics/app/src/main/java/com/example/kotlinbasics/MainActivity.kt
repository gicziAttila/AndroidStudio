package com.example.kotlinbasics

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var greetingButton: Button
    private lateinit var openCalculatorButton: Button
    private lateinit var openWeatherButton: Button
    private lateinit var openUserList: Button
    private lateinit var openRandomUserList: Button
    private lateinit var openStudentCount: Button
    private lateinit var openColorList: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.main_activity)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        //Ui elemek inicializálása
        greetingButton = findViewById(R.id.greetingButton)
        openCalculatorButton = findViewById(R.id.openCalculatorButton)
        openWeatherButton = findViewById(R.id.openWeatherButton)
        openUserList = findViewById(R.id.openUserList)
        openRandomUserList = findViewById(R.id.openRandomUserList)
        openStudentCount = findViewById(R.id.openStudetnCount)
        openColorList = findViewById(R.id.openColorList)


        greetingButton.setOnClickListener(){
            val intent = Intent(this, GreetingActivity::class.java)
            startActivity(intent)
        }
        //-----------------------------------------
        openCalculatorButton.setOnClickListener(){
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }
        //-----------------------------------------
        openWeatherButton.setOnClickListener(){
            val intent = Intent(this, WeatherActivity::class.java)
            startActivity(intent)
        }
        //-----------------------------------------
        openUserList.setOnClickListener(){
            val intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
        }
        //-----------------------------------------
        openRandomUserList.setOnClickListener(){
            val intent = Intent(this, RandomUserListActivity::class.java)
            startActivity(intent)
        }
        //-----------------------------------------
        openStudentCount.setOnClickListener(){
            val intent = Intent(this, ApiActivity::class.java)
            startActivity(intent)
        }
        //-----------------------------------------
        openColorList.setOnClickListener(){
            val intent = Intent(this, ColorListActivity::class.java)
            startActivity(intent)
        }
    } //ON CREATE
}
