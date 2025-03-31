package com.example.kotlinbasics

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics.adapter.ColorAdapter
import com.example.kotlinbasics.model.Colors
import com.example.kotlinbasics.network.ColorService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ColorListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_list)

        val recyclerView: RecyclerView = findViewById(R.id.colorListRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            try {
                val colorList = fetchColorList()
                if (!colorList.isNullOrEmpty()) {
                    recyclerView.adapter = ColorAdapter(colorList)
                } else {
                    Log.e("Color activity hiba", "A recyclerview nem található")
                }
            } catch (e: Exception) {
                Log.e("Color activity hiba", "Hiba az adatletöltésben", e)
            }
        }
    }

    private suspend fun fetchColorList(): List<Colors>? {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/unknown/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val colorService = retrofit.create(ColorService::class.java)
        return withContext(Dispatchers.IO) {
            try {
                val response = colorService.getColors()
                response.data
            } catch (e: Exception) {
                Log.e("HIBA", "HIBA az API kérés során", e)
                null
            }
        }
    }
}