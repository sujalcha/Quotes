package com.xtha.zujal.quotes

import com.xtha.zujal.quotes.models.Quote
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Quote> {
        return RetrofitClientInstance.api.getPost()
    }
}