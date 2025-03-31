package com.example.kotlinbasics.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

import com.example.kotlinbasics.model.WeatherResponse

interface WeatherService{
    @GET("data/2.5/weather")
    fun getWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String,
    ): Call<WeatherResponse>
}