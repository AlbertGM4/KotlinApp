package com.example.kotlinapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinapp.model.User
import com.example.kotlinapp.model.api.ApiServiceImpl
import com.example.kotlinapp.model.dto.CreateUserDto
import com.example.kotlinapp.viewmodel.utils.AuthValidator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// ViewModel
class AuthViewModel : ViewModel() {
    // Estados de la autenticación
    sealed class AuthState {
        data class Loading(val loading: Boolean) : AuthState()
        data class Success(val user: User) : AuthState()
        data class Error(val message: String) : AuthState()
    }

    private val _authState = MutableStateFlow<AuthState>(AuthState.Loading(false))
    val authState: StateFlow<AuthState> = _authState

    // Método para iniciar sesión
    fun signInUser(username: String, password: String) {
        val result = AuthValidator.validateSignInRequest(username, password)
        if (result.successful) {
            viewModelScope.launch {
                _authState.value = AuthState.Loading(true)
                try {
                    // Lógica para iniciar sesión, como llamar a la API
                    // Actualizar el estado según el resultado
                    val response = ApiServiceImpl.api.signIn(username, password)
                    val user =
                        response.body()?.user // Suponiendo que la respuesta de la API incluye los detalles del usuario
                    _authState.value = AuthState.Success(user)
                } catch (e: Exception) {
                    _authState.value = AuthState.Error(e.message ?: "Error desconocido")
                } finally {
                    _authState.value = AuthState.Loading(false)
                }
            }
        }
    }

    // Método para registrar un usuario
    fun signUpUser(createUserDto: CreateUserDto) {
        val result = AuthValidator.validateSignUpRequest(createUserDto)
        viewModelScope.launch {
            _authState.value = AuthState.Loading(true)
            try {
                // Lógica para registrar un usuario, como llamar a la API
                // Actualizar el estado según el resultado
                val response = ApiServiceImpl.api.signUp(createUserDto)
                val user = response.body()?.user // Suponiendo que la respuesta de la API incluye los detalles del usuario
                    _authState.value = AuthState.Success(user)
            } catch (e: Exception) {
                _authState.value = AuthState.Error(e.message ?: "Error desconocido")
            } finally {
                _authState.value = AuthState.Loading(false)
            }
        }
    }
}