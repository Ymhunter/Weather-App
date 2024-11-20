package com.example.weatherapp.Api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherResultDTO(
    @Json(name = "current")
    val current: Current? = Current(),
    @Json(name = "location")
    val location: Location? = Location()
)
