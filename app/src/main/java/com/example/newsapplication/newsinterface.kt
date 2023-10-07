package com.example.newsapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface newsinterface {
    @GET("top-headlines")
    fun getNews(@Query("country") Country: String,@Query("category") category
    : String, @Query("apiKey") apiKey: String) :Call<NewsList>
}