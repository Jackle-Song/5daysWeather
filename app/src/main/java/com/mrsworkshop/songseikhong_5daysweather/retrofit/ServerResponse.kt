package com.mrsworkshop.songseikhong_5daysweather.retrofit

open class ServerResponse<T> {
    val code = 0
    val message: String? = null
    val error: String? = null
    val data: T? = null
    val isSuccessful: Boolean
        get() = message == "Success!"
}