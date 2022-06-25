package com.mrsworkshop.songseikhong_5daysweather.Viewmodel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class WeatherDetailsViewModel(
    val id: Int?,
    val main: String?,
    val description: String?,
    val icon: String?,
) : Parcelable