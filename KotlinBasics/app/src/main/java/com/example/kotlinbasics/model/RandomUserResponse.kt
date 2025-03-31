package com.example.kotlinbasics.model

data class RandomUserResponse(
    val results: List<RUser>
)
data class RUser(
    val name: RName,
    val email: String,
    val picture: RPicture,
    val location: RLocation,
)
data class RName(
    val title: String,
    val first: String,
    val last: String
)
data class RLocation(
    val city: String,
    val country: String
)
data class RPicture(
    val medium: String,
)