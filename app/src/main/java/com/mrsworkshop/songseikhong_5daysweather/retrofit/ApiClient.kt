package com.mrsworkshop.songseikhong_5daysweather.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    fun retrofitService(): ApiInterface {
        return Retrofit.Builder()
            .baseUrl(ApiInterface.BASE_URL)
            .client(execOkHttpClient())
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(ApiInterface::class.java)
    }

    private fun execOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level =
            HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS)
            .build()
    }
}