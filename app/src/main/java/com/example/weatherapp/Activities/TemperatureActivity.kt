package com.example.weatherapp.Activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.weatherapp.Common.City
import com.example.weatherapp.Common.Weather
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ActivityTemperatureBinding
import kotlinx.coroutines.launch


class TemperatureActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTemperatureBinding
    private val viewModel: TemperatureViewModel by viewModels { TemperatureViewModel.factory(city()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature)
        binding = ActivityTemperatureBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observerState()
        configureToolbar()
    }

    private fun observerState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.state.collect { state ->
                    when (state) {
                        TemperatureState.Loading -> {
                        }

                        TemperatureState.Failure -> {
//
                        }

                        is TemperatureState.Success -> {
                            showWeather(weather = state.city)
                        }
                    }
                }
            }
        }
    }
    private fun city(): String {
        return intent.getParcelableExtra<City>(KEY_CITY)!!.nameCity
    }
    private fun configureToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
    }

    private fun showWeather(weather: Weather?) {
        binding.apply {
            condition.text = "${weather?.description}"
            temperature.text = "${weather?.tempC}°c"
            uvIndex.text = "${weather?.uv}"
            humidity.text = "${weather?.humidity}%"
            cloudiness.text = "${weather?.cloud}%"
        }
        val isDay = "${weather?.day}".toInt()
        if (binding.condition.text == "Sunny") {
            binding.sunnyImage.setImageResource(R.drawable.background_sunny)
        } else if (binding.condition.text.contains("rain") || binding.condition.text.contains("Mist")) {
            binding.sunnyImage.setImageResource(R.drawable.background_rainy)
        } else if (binding.condition.text.contains("cloudy") || binding.condition.text.contains("Overcast")) {
            binding.sunnyImage.setImageResource(R.drawable.background_cloudy)
        } else if (isDay == 1) {
            binding.sunnyImage.setImageResource(R.drawable.background_night)
        }
    }

    companion object {
        private const val KEY_CITY = "CITY_NAME"
    }
}
