package com.example.kotlinbasics.model
data class ColorResponse (
    val data: List<Colors>
)
data class Colors(
    val name: String,
    val year: String,
    val color: String,
    val pantone_value: String
)