package com.example.kotlinapp.model.api

import com.example.kotlinapp.model.User
import com.example.kotlinapp.model.dto.CreateUserDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("signup")
    suspend fun signUp(@Body createUserDto: CreateUserDto): Response<User>
    @GET("signin")
    suspend fun signIn(@Body username: String, password: String): Response<User>
}