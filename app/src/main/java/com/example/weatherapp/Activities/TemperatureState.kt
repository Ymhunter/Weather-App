package com.example.weatherapp.Activities

import com.example.weatherapp.Common.Weather

sealed class TemperatureState {
    object Loading : TemperatureState()
    data class Success(val city: Weather?) : TemperatureState()
    object Failure : TemperatureState()
}