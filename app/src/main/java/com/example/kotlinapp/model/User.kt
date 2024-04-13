package com.example.kotlinapp.model


data class User(
    val email: String,
    val password: String,
    val username: String,
    val name: String,
    val surname: String,
    val mobile: String,
    val bio: String,
    val age: Int
)

class UserRepository {
    fun getUserData(): User {
        // Fetch weather data from a remote server or local storage ->

        return User("example@example.com","password",
            "Test", "testname", "testsurname",
            "123456789", "About me", 18)
    }
}