package com.example.kotlinapp.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object ApiServiceImpl {
    private const val BASE_URL = "https://example.com/api/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}