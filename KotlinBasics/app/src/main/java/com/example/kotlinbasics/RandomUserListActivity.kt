package com.example.kotlinbasics

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics.adapter.RandomUserAdapter
import com.example.kotlinbasics.adapter.UserAdapter
import com.example.kotlinbasics.model.RUser
import com.example.kotlinbasics.model.RandomUserResponse
import com.example.kotlinbasics.model.WeatherResponse
import com.example.kotlinbasics.network.RandomUserService
import com.example.kotlinbasics.network.WeatherService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.random.Random


class RandomUserListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_users)

        val recycylerView : RecyclerView = findViewById(R.id.randomUserListRecyclerView);
        recycylerView.layoutManager = LinearLayoutManager(this)
        lifecycleScope.launch {
            try {
                val randomUsers = fetchRandomUserList()
                if(!randomUsers.isNullOrEmpty()){
                    recycylerView.adapter = RandomUserAdapter(randomUsers)
                }else{
                    Log.e("Userlist activity hiba", "A recyclerview nem található")
                }
                recycylerView.adapter = randomUsers?.let { RandomUserAdapter(it) }
            } catch (e: Exception) {
                Log.e("Userlist activity hiba", "Hiba az adatletöltésben")
            }
        }
    }

    private suspend fun fetchRandomUserList(): List<RUser>? {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val randomUserService = retrofit.create(RandomUserService::class.java)
        return withContext(Dispatchers.IO) {
            try {
                val response = randomUserService.getRandomUsers("10")
                response.results
            } catch (e: Exception) {
                Log.e("HIBA", "HIBA az API kérés során")
                null
            }
        };
    }
}