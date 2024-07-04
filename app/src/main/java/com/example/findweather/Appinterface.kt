package com.example.findweather

import retrofit2.http.GET
import retrofit2.http.Query

interface Appinterface {
    @GET("weather")
    fun getWeatherData(
        @Query("q") city:String,
        @Query("appid") apiid :String,
        @Query("units") units:String
    ) : retrofit2.Call<WeatherApp>
}