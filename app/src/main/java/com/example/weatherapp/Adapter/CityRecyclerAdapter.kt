package com.example.weatherapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.Common.City
import com.example.weatherapp.databinding.GridLayoutListItemBinding

class CityRecyclerAdapter(
    private val cities: List<City>,
    private val onCellClicked: (City) -> Unit,
) : RecyclerView.Adapter<CityRecyclerAdapter.CityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        return CityViewHolder.create(parent, onCellClicked)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = cities[position]
        holder.bind(city)
    }

    override fun getItemCount(): Int {
        return cities.size
    }

    class CityViewHolder(
        private var binding: GridLayoutListItemBinding,
        private val onCellClicked: (City) -> Unit,
        private val context: Context
    ) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(city: City) {
            binding.iconImage.setBackgroundResource(city.image)
            binding.cardView.setOnClickListener {
                onCellClicked(city)
            }
        }
        companion object {
            fun create(parent: ViewGroup, onCellClicked: (City) -> Unit,): CityViewHolder {
                val binding = GridLayoutListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return CityViewHolder(binding = binding, onCellClicked = onCellClicked, context = parent.context)
            }
        }
    }
}
