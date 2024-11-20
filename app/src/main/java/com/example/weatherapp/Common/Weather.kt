package com.example.weatherapp.Common

import android.os.Parcelable
import com.example.weatherapp.Api.Current
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weather(
    val description: String,
    val tempC: Double,
    val cloud: Int,
    val uv: Double,
    val humidity: Int,
    val day: Int,
) : Parcelable {
    constructor(dto: Current) : this(
        description = dto.condition?.text ?: "",
        tempC = dto.tempC ?: 0.0,
        cloud = dto.cloud ?: 0,
        uv = dto.uv ?: 0.0,
        humidity = dto.humidity ?: 0,
        day = dto.isDay ?: 0,
    )
}