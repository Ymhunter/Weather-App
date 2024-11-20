package com.example.weatherapp.Activities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.Common.City
import com.example.weatherapp.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private val _state = MutableStateFlow(cities())
    val state: StateFlow<List<City>> = _state

    private fun cities(): List<City> {
        return listOf(
            City(nameCity = "agra", image = R.drawable.agra,),
            City(nameCity = "barcelona", image = R.drawable.barcelona),
            City(nameCity = "beijing", image = R.drawable.beijing),
            City(nameCity = "sydney", image = R.drawable.sydney),
            City(nameCity = "paris", image = R.drawable.paris),
            City(nameCity = "new_york", image = R.drawable.new_york),
            City(nameCity = "london", image = R.drawable.london),
            City(nameCity = "rio_de_janeiro", image = R.drawable.rio_de_janeiro),
            City(nameCity = "moscow", image = R.drawable.moscow),
            City(nameCity = "rome", image = R.drawable.rome),
        )
    }
    companion object {
        fun factory(): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return MainViewModel() as T
                }
            }
        }
    }
}
