package com.example.weatherapp.Activities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.Api.Current
import com.example.weatherapp.Api.WeatherResultDTO
import com.example.weatherapp.Common.Weather
import com.example.weatherapp.Utilities.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TemperatureViewModel(private val cityName: String) : ViewModel() {
    private val _state = MutableStateFlow<TemperatureState>(TemperatureState.Loading)
    val state: StateFlow<TemperatureState> = _state

    init {
        retrieveCity()
    }
    private fun retrieveCity() {
        weatherOnTime().enqueue(object : Callback<
                WeatherResultDTO> {
            override fun onResponse(call: Call<WeatherResultDTO>, response: Response<WeatherResultDTO>) {
                if (isSuccessful(response)) {
                    val data = cities(current = response.body()!!.current!!)
                    _state.value = TemperatureState.Success(
                        city = data
                    )
                } else {
                    _state.value = TemperatureState.Failure
                }
            }

            override fun onFailure(call: Call<WeatherResultDTO>, t: Throwable) {
                _state.value = TemperatureState.Failure
            }
        })
    }
    private fun cities(current: Current): Weather {
        return Weather(current)
    }

    private fun weatherOnTime(): Call<WeatherResultDTO> {
        return RetrofitClient.instance.getCityWeatherData(
            apiKey = "c180ca5e6e544acda0292128242011",
            city = cityName,
        )
    }

    private fun isSuccessful(response: Response<WeatherResultDTO>): Boolean {
        return response.isSuccessful && response.body() != null && response.body()!!.current?.tempC != null
    }

    companion object {
        fun factory(cityName: String): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return TemperatureViewModel(cityName) as T
                }
            }
        }
    }
}
