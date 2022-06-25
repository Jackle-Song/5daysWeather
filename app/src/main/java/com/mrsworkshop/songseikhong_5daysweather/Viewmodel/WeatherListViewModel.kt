package com.mrsworkshop.songseikhong_5daysweather.Viewmodel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class WeatherListViewModel(
    val weather: List<WeatherDetailsViewModel>?,
) : Parcelable