package com.example.kotlinbasics.network

import com.example.kotlinbasics.model.StudentResponse
import retrofit2.http.GET

interface StudentService {
    @GET("api.php")
    suspend fun getStudent(): StudentResponse
}