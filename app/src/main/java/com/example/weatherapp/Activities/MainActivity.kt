package com.example.weatherapp.Activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.weatherapp.Adapter.CityRecyclerAdapter
import com.example.weatherapp.Common.City
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels { MainViewModel.factory() }
    private var gridLayoutManger: GridLayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gridLayoutManger = GridLayoutManager(this, 2)
        binding.recyclerView.layoutManager = gridLayoutManger
        binding.recyclerView?.setHasFixedSize(true)

        observerState()
        configureToolbar()
    }
    private fun observerState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.state.collect(::showCities)
            }
        }
    }

    private fun showCities(cities: List<City>) {
        binding.recyclerView.apply {
            adapter = CityRecyclerAdapter(cities, onCellClicked = ::showTemperature)
            setHasFixedSize(true)
        }
    }
    private fun showTemperature(city: City) {
        startActivity(intent(this, city))
    }
    private fun configureToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
    }
    companion object {
        private const val KEY_CITY = "CITY_NAME"

        fun intent(context: Context, city: City): Intent {
            val intent = Intent(context, TemperatureActivity::class.java)
            intent.putExtra(KEY_CITY, city)
            return intent
        }
    }
}
