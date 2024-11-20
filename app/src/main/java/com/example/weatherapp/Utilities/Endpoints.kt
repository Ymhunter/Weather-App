package com.example.weatherapp.Utilities

import com.example.weatherapp.Api.WeatherResultDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoints {
    @GET("current.json")
    fun getCityWeatherData(
        @Query("q") city: String,
        @Query("key") apiKey: String,
    ): Call<WeatherResultDTO>
}
