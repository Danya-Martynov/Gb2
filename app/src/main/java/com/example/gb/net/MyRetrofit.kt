package com.example.gb.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRetrofit {
    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("http://mskko2021.mad.hatka.pro/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}