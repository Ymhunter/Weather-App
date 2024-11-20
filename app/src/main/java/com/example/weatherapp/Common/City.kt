package com.example.weatherapp.Common

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class City(
    val nameCity: String,
    @DrawableRes val image: Int,
) : Parcelable
