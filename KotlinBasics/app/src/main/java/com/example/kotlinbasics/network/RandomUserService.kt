package com.example.kotlinbasics.network

import com.example.kotlinbasics.model.RandomUserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RandomUserService{
    @GET("/api/")
    suspend fun getRandomUsers(
        @Query("results") results: String,
    ): RandomUserResponse
}