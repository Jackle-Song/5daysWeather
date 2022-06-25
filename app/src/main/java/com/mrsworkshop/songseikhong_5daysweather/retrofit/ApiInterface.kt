package com.mrsworkshop.songseikhong_5daysweather.retrofit

import com.mrsworkshop.songseikhong_5daysweather.Viewmodel.ViewModel
import com.mrsworkshop.songseikhong_5daysweather.Viewmodel.WeatherViewModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("forecast")
    suspend fun dailyForecast(@Query("q") cityName: String, @Query("appid") access_token: String, @Query("cnt") days : Int)
            : Response<ViewModel>

    companion object {
        val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    }
}
