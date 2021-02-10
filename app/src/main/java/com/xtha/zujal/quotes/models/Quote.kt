package com.xtha.zujal.quotes.models

import com.google.gson.annotations.SerializedName

class Quote(
    @field:SerializedName("id") var id: Int,
    @field:SerializedName("tags") var tags: Array<String>,
    @field:SerializedName("content") var content: String,
    @field:SerializedName("author") var author: String,
    @field:SerializedName("length") var length: String
)