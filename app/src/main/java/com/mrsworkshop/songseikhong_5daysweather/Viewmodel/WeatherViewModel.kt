package com.mrsworkshop.songseikhong_5daysweather.Viewmodel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class WeatherViewModel(
    val cod: String?,
    val message: Int?,
    val cnt: Int?,
    val list: List<WeatherListViewModel>?,
) : Parcelable