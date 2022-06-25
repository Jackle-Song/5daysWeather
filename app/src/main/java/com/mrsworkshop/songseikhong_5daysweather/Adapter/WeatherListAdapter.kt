package com.mrsworkshop.songseikhong_5daysweather.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrsworkshop.songseikhong_5daysweather.Viewmodel.WeatherDetailsViewModel
import com.mrsworkshop.songseikhong_5daysweather.Viewmodel.WeatherItem
import com.mrsworkshop.songseikhong_5daysweather.databinding.ItemRecyclerCardDesignBinding

class WeatherListAdapter(
    private val weatherDetailsListing: List<WeatherItem?>,
    private val context: Context,

    ) : RecyclerView.Adapter<WeatherListAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemRecyclerCardDesignBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRecyclerCardDesignBinding.inflate(
                LayoutInflater.from(
                    viewGroup.context
                ), viewGroup, false
            )
        )
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val weatherDetails = weatherDetailsListing[position]

        viewHolder.binding.statusTv.text = weatherDetails?.main
        viewHolder.binding.status2Tv.text = weatherDetails?.description
    }

    override fun getItemCount() = weatherDetailsListing.size
}