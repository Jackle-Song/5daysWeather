package com.mrsworkshop.songseikhong_5daysweather

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrsworkshop.songseikhong_5daysweather.Adapter.WeatherListAdapter
import com.mrsworkshop.songseikhong_5daysweather.Viewmodel.WeatherItem
import com.mrsworkshop.songseikhong_5daysweather.databinding.ActivityMainBinding
import com.mrsworkshop.songseikhong_5daysweather.retrofit.ApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var weatherAdapter: WeatherListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        getWeatherApi()
    }

    private fun getWeatherApi() {
        val service = ApiClient.retrofitService()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.dailyForecast("Kuala Lumpur", "d4ee23add448ac4f0313b2556d2e4627",5)
            try {
                withContext(Dispatchers.Main) {
                    if (response?.isSuccessful == true && response.body() != null) {
                        response.body()?.let {
                            it.list?.get(0)?.weather.let { it1 ->
                                runOnUiThread {
                                    weatherAdapter =
                                        it1?.let { it2 -> WeatherListAdapter(it2, applicationContext) }
                                    binding.recyclerRv.adapter = weatherAdapter
                                    binding.recyclerRv.layoutManager = LinearLayoutManager(
                                        applicationContext,
                                        LinearLayoutManager.VERTICAL,
                                        false
                                    )
                                }
                            }
                        }
                    }
                }
            } catch (e: HttpException) {
                Timber.d("Exception ${e.message}")
            }
        }
    }
}