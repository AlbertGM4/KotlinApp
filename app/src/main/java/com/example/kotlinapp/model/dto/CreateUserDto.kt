package com.example.kotlinapp.model.dto

data class CreateUserDto(
    val uid: String = "",
    val email: String,
    val password: String,
    val username: String,
    val name: String = "",
    val surname: String = "",
    val mobile: String = "",
    val bio: String = "",
    val age: Int = 0
)