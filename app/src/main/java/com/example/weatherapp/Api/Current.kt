package com.example.weatherapp.Api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Current(
    @Json(name = "cloud")
    val cloud: Int? = 0,
    @Json(name = "condition")
    val condition: Condition? = Condition(),
    @Json(name = "feelslike_c")
    val feelslikeC: Double? = 0.0,
    @Json(name = "feelslike_f")
    val feelslikeF: Double? = 0.0,
    @Json(name = "gust_kph")
    val gustKph: Double? = 0.0,
    @Json(name = "gust_mph")
    val gustMph: Double? = 0.0,
    @Json(name = "humidity")
    val humidity: Int? = 0,
    @Json(name = "is_day")
    val isDay: Int? = 0,
    @Json(name = "last_updated")
    val lastUpdated: String? = "",
    @Json(name = "last_updated_epoch")
    val lastUpdatedEpoch: Int? = 0,
    @Json(name = "precip_in")
    val precipIn: Double? = 0.0,
    @Json(name = "precip_mm")
    val precipMm: Double? = 0.0,
    @Json(name = "pressure_in")
    val pressureIn: Double? = 0.0,
    @Json(name = "pressure_mb")
    val pressureMb: Double? = 0.0,
    @Json(name = "temp_c")
    val tempC: Double? = 0.0,
    @Json(name = "temp_f")
    val tempF: Double? = 0.0,
    @Json(name = "uv")
    val uv: Double? = 0.0,
    @Json(name = "vis_km")
    val visKm: Double? = 0.0,
    @Json(name = "vis_miles")
    val visMiles: Double? = 0.0,
    @Json(name = "wind_degree")
    val windDegree: Int? = 0,
    @Json(name = "wind_dir")
    val windDir: String? = "",
    @Json(name = "wind_kph")
    val windKph: Double? = 0.0,
    @Json(name = "wind_mph")
    val windMph: Double? = 0.0
)
