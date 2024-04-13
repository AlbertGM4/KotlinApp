package com.example.kotlinapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlinapp.view.SignIn
import com.example.kotlinapp.view.SignUp
import com.example.kotlinapp.view.navigation.MainDestinations
import com.example.kotlinapp.view.navigation.rememberNavController
import com.example.kotlinapp.view.ui.theme.KotlinAppTheme
import com.example.kotlinapp.viewmodel.AuthViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinAppTheme {
                val navController = rememberNavController()
                val authViewModel: AuthViewModel = viewModel()
                NavHost(
                    navController = navController.navController,
                    startDestination = MainDestinations.SIGN_IN_ROUTE
                ) {
                    tripgramNavGraph(
                        authViewModel = authViewModel,
                        onNavigateToSignIn = navController::navigateToSignIn,
                        onNavigateToSignUp = navController::navigateToSignUp
                    )
                }
            }
        }
    }
}

private fun NavGraphBuilder.tripgramNavGraph(
    authViewModel: AuthViewModel,
    onNavigateToSignIn: () -> Unit,
    onNavigateToSignUp: () -> Unit,
) {
    // Sign In
    composable(
        MainDestinations.SIGN_IN_ROUTE,
    ) {
        SignIn(authViewModel, onNavigateToSignUp)
    }
    // Sign Up
    composable(
        MainDestinations.SIGN_UP_ROUTE,
    ) {
        SignUp(authViewModel, onNavigateToSignIn)
    }
}
