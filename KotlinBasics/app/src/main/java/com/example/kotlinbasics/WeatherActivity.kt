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
import com.example.kotlinbasics.model.WeatherResponse
import com.example.kotlinbasics.network.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherActivity : AppCompatActivity() {

    private lateinit var textviewTempFail: TextView
    private lateinit var textviewWindSpeed: TextView
    private lateinit var textviewTemp: TextView
    private lateinit var textviewHumidity: TextView
    private lateinit var editTextCity: EditText
    private lateinit var searchCity: Button

    private val apiKey = "9bfbafc985c43cdd9972fa09d0949353"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_weather)
        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
          //  val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            //v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            //insets
       //}

        textviewTempFail =findViewById(R.id.textview_tempFail)
        textviewWindSpeed =findViewById(R.id.textview_windspeed)
        textviewTemp =findViewById(R.id.textview_temp)
        textviewHumidity =findViewById(R.id.textview_humidity)
        editTextCity =findViewById(R.id.cityEditText)
        searchCity = findViewById(R.id.searchButton)


        fetchWeatherData()
    }
    private fun fetchWeatherData(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val weatherService = retrofit.create(WeatherService::class.java)
        searchCity.setOnClickListener(){
            val city = editTextCity.text
            val call = weatherService.getWeather(city.toString(), apiKey, "metric")
            call.enqueue(object:Callback<WeatherResponse> {
                override fun onResponse(
                    call: Call<WeatherResponse>,
                    response: Response<WeatherResponse>
                ) {
                    if(response.isSuccessful){
                        val weatherResponse = response.body()
                        if(weatherResponse != null){
                            val temp = weatherResponse.main.temp;
                            val humidity = weatherResponse.main.humidity;
                            val windSpeed = weatherResponse.wind.speed;
                            textviewTempFail.text = ""
                            textviewTemp.text = city.toString() + " hőmérséklete: "  + temp.toString() + "°C";
                            textviewHumidity.text = city.toString() + " páratartalma: " + humidity.toString() + "%";
                            textviewWindSpeed.text = city.toString() + " szél ereje: " + windSpeed.toString() + "m/s";
                        }
                    }
                    else{
                        textviewTemp.text = ""
                        textviewHumidity.text = ""
                        textviewWindSpeed.text = ""
                        textviewTempFail.text = "A lekérdezés meghiúsult!"
                    }
                }
                override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                    Log.e("HIBA ","HIBA az API kérés során")
                }
            })
        }
    }
}