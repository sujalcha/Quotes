package com.example.retrofitdemo.api

import com.xtha.zujal.quotes.models.Quote
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {

    @GET("random")
    suspend fun getPost(): Response<Quote>

}