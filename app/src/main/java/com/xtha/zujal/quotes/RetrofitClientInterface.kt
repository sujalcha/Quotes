package com.xtha.zujal.quotes

import com.example.retrofitdemo.api.SimpleApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClientInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.quotable.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}