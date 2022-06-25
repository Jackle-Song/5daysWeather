package com.mrsworkshop.songseikhong_5daysweather.Viewmodel

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ViewModel(
	val city: City? = null,
	val cnt: Int? = null,
	@SerializedName ("cod") @Expose val cod: String?,
	val message: Int? = null,
	@SerializedName ("list") @Expose val list: List<ListItem?>?
) : Parcelable

@Parcelize
data class WeatherItem(
	val icon: String? = null,
	val description: String? = null,
	val main: String? = null,
	val id: Int? = null
) : Parcelable

@Parcelize
data class ListItem(
	val dt: Int? = null,
	val pop: Double? = null,
	val rain: Rain? = null,
	val visibility: Int? = null,
	@SerializedName ("dt_txt") @Expose val dt_txt: String?,
	@SerializedName ("weather") @Expose val weather: List<WeatherItem?>?,
	val main: Main? = null,
	val clouds: Clouds? = null,
	val sys: Sys? = null,
	val wind: Wind? = null
) : Parcelable

@Parcelize
data class Rain(
	val jsonMember3h: Double? = null
) : Parcelable

@Parcelize
data class Sys(
	val pod: String? = null
) : Parcelable

@Parcelize
data class Coord(
	val lon: Double? = null,
	val lat: Double? = null
) : Parcelable

@Parcelize
data class City(
	val country: String? = null,
	val coord: Coord? = null,
	val sunrise: Int? = null,
	val timezone: Int? = null,
	val sunset: Int? = null,
	val name: String? = null,
	val id: Int? = null,
	val population: Int? = null
) : Parcelable

@Parcelize
data class Main(
	val temp: Double? = null,
	val tempMin: Double? = null,
	val grndLevel: Int? = null,
	val tempKf: Double? = null,
	val humidity: Int? = null,
	val pressure: Int? = null,
	val seaLevel: Int? = null,
	val feelsLike: Double? = null,
	val tempMax: Double? = null
) : Parcelable

@Parcelize
data class Clouds(
	val all: Int? = null
) : Parcelable

@Parcelize
data class Wind(
	val deg: Int? = null,
	val speed: Double? = null,
	val gust: Double? = null
) : Parcelable
