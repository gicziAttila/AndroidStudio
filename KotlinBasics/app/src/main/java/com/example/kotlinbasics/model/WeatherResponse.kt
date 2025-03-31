package com.example.kotlinbasics.model

import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.service.controls.Control

data class WeatherResponse(
    val main: Main,
    val wind: Wind,
)
data class Main(
    val temp: Double,
    val humidity: Short,
)
data class Wind(
    val speed: Double,
)