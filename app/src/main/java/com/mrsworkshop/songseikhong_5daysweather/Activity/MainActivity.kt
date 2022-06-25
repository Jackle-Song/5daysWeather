package com.mrsworkshop.songseikhong_5daysweather

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.mrsworkshop.songseikhong_5daysweather.Adapter.WeatherListAdapter
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

        if (!binding.searchEt.equals("")){
            binding.searchTv.setOnClickListener {
                closeKeyboard()
                getWeatherApi()
            }
        }
    }

    private fun getWeatherApi() {
        val progressDialog = ProgressDialog(this@MainActivity)
        progressDialog.setTitle("Weathers")
        progressDialog.setMessage("Data is loading, please wait")
        progressDialog.show()
        val service = ApiClient.retrofitService()
        val city = binding.searchEt.text.toString()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.dailyForecast(city, "d4ee23add448ac4f0313b2556d2e4627")
            try {
                withContext(Dispatchers.Main) {
                    if (response?.isSuccessful == true && response.body() != null) {
                        progressDialog.dismiss()
                        response.body()?.let {
                            it.list?.let { it1 ->
                                runOnUiThread {
                                    weatherAdapter =
                                        it1?.let { it2 -> WeatherListAdapter(it2, applicationContext) }
                                    binding.recyclerRv.adapter = weatherAdapter
                                    binding.recyclerRv.layoutManager = GridLayoutManager(applicationContext, 2)
                                }
                            }
                        }
                    }else{
                        progressDialog.dismiss()
                        Toast.makeText(this@MainActivity, "Invalid City", Toast.LENGTH_LONG).show()
                    }
                }
            } catch (e: HttpException) {
                progressDialog.dismiss()
                Timber.d("Exception ${e.message}")
            }
        }
    }
    private fun closeKeyboard() {

        val view: View? = this.currentFocus

        if (view != null) {

            val manager: InputMethodManager = getSystemService(
                Context.INPUT_METHOD_SERVICE
            ) as InputMethodManager
            manager
                .hideSoftInputFromWindow(
                    view.windowToken, 0
                )
        }
    }
}