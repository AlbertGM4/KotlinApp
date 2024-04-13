package com.example.kotlinapp.viewmodel.utils

import com.example.kotlinapp.model.dto.CreateUserDto

data class ValidationResult(
    val successful: Boolean,
    val error: String? = null
)
object AuthValidator {
    fun validateSignInRequest(username: String, password: String): ValidationResult {
        if (password.isBlank() && username.isBlank()) {
            return ValidationResult(
                successful = false,
                error = "Email and Password fields are empty"
            )
        }
        if (username.isBlank()) {
            return ValidationResult(
                successful = false,
                error = "Username cannot be blank"
            )
        }
//        if (email.isBlank()) {
//            return ValidationResult(
//                successful = false,
//                error = "Email cannot be blank"
//            )
//        }
//        if (email.isNotBlank()) {
//            val email_regex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
//            val matches = email_regex.toRegex().matches(email)
//            if (!matches) {
//                return ValidationResult(
//                    successful = false,
//                    error = "Email is not valid"
//                )
//            }
//        }
        if (password.isBlank()) {
            return ValidationResult(
                successful = false,
                error = "Password cannot be blank"
            )
        }
        return ValidationResult(successful = true,)
    }

    fun validateSignUpRequest(createUserDto: CreateUserDto): ValidationResult {
        val email = createUserDto.email
        val password = createUserDto.password
        val username = createUserDto.username
//        val name = createUserDto.,
//        val surname = createUserDto.,
        val mobile = createUserDto.mobile
//        val bio = createUserDto.,
//        val age = createUserDto.

        if (username.isBlank() && password.isBlank() && email.isBlank() && username.isBlank()) {
            return ValidationResult(
                successful = false,
                error = "All fields are empty"
            )
        }
        if (email.isBlank()) {
            return ValidationResult(
                successful = false,
                error = "Email cannot be blank"
            )
        }
        if (email.isNotBlank()) {
            val email_regex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
            val matches = email_regex.toRegex().matches(email)
            if (!matches) {
                return ValidationResult(
                    successful = false,
                    error = "Email is not valid"
                )
            }
        }
//        if (fullName.isBlank()) {
//            return ValidationResult(
//                successful = false,
//                error = "FullName cannot be blank"
//            )
//        }
        if (username.isBlank()) {
            return ValidationResult(
                successful = false,
                error = "Username cannot be blank"
            )
        }
        if (password.isBlank()) {
            return ValidationResult(
                successful = false,
                error = "Password cannot be blank"
            )
        }
        if (password.length < 6) {
            return ValidationResult(
                successful = false,
                error = "Password length should be at least 6 characters."
            )
        }
        return ValidationResult(successful = true,)
    }
}