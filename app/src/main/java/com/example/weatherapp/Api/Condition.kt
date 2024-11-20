package com.example.weatherapp.Api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Condition(
    @Json(name = "code")
    val code: Int? = 0,
    @Json(name = "icon")
    val icon: String? = "",
    @Json(name = "text")
    val text: String? = ""
)

