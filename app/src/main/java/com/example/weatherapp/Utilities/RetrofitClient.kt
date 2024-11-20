package com.example.weatherapp.Utilities

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {
    private const val baseUrl = "https://api.weatherapi.com/v1/"

    val instance: Endpoints by lazy {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(baseUrl)
            .build()

        retrofit.create(Endpoints::class.java)
    }
}
