package com.example.kotlinapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlinapp.navigation.MainDestinations
import com.example.kotlinapp.navigation.rememberNavController
import com.example.kotlinapp.screens.SignIn
import com.example.kotlinapp.screens.SignUp
import com.example.kotlinapp.ui.theme.KotlinAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController.navController,
                    startDestination = MainDestinations.SIGN_IN_ROUTE
                ) {
                    tripgramNavGraph(
                        onNavigateToSignIn = navController::navigateToSignIn,
                        onNavigateToSignUp = navController::navigateToSignUp
                    )
                }
            }
        }
    }
}


private fun NavGraphBuilder.tripgramNavGraph(
    onNavigateToSignIn: () -> Unit,
    onNavigateToSignUp: () -> Unit,
) {
    // Sign In
    composable(
        MainDestinations.SIGN_IN_ROUTE,
    ) {
        SignIn(onNavigateToSignUp)
    }
    // Sign Up
    composable(
        MainDestinations.SIGN_UP_ROUTE,
    ) {
        SignUp(onNavigateToSignIn)
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    KotlinAppTheme {
//        Greeting("Android")
//    }
//}