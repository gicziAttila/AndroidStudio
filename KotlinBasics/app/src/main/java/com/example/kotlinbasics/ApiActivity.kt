package com.example.kotlinbasics

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.kotlinbasics.network.StudentService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiActivity : AppCompatActivity() {
    private lateinit var textViewCountId: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.api_endpoint)
        textViewCountId = findViewById(R.id.textViewCountId)
        lifecycleScope.launch {
            try {
                fetchStudentCount()
            } catch (e: Exception) {
                Log.e("Userlist activity hiba", "Hiba az adatletöltésben")
            }
        }
    }

    private suspend fun fetchStudentCount() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://banki13.komarom.net/2024/giczia/PHP/controllers/api.php/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val studentService = retrofit.create(StudentService::class.java)
        withContext(Dispatchers.IO) {
            try {
                val response = studentService.getStudent()
                withContext(Dispatchers.Main) {
                    textViewCountId.text = "Student count: " +  response.count
                }
            } catch (e: Exception) {
                Log.e("HIBA", "HIBA az API kérés során")
            }
        }
    }
}