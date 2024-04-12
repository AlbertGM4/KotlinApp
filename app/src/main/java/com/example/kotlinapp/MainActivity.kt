package com.example.kotlinapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.kotlinapp.navigation.MainDestinations
import com.example.kotlinapp.navigation.NavController
import com.example.kotlinapp.navigation.rememberNavController
import com.example.kotlinapp.screens.SignIn
import com.example.kotlinapp.screens.SignUp
import com.example.kotlinapp.ui.theme.KotlinAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinAppTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
                val NavController = rememberNavController()
                NavHost(
                    navController = NavController.navController,
                    startDestination = MainDestinations.SIGN_IN_ROUTE
                ) {
                    tripgramNavGraph(
                        // Hacia donde vamos --> navigateToSnackDetail
                        onNavigateToSignUp = NavController::navigateToSignUp
//                        upPress = NavController::upPress,
//                        onNavigateToRoute = NavController::navigateToBottomBarRoute
                    )
                }
            }
        }
    }
}


private fun NavGraphBuilder.tripgramNavGraph(
//    NavBackStackEntry
    onNavigateToSignUp: () -> Unit,
    //upPress: () -> Unit,
    //onNavigateToRoute: (String) -> Unit
) {
//    navigation(
//        route = MainDestinations.SIGN_IN_ROUTE,
//        startDestination = MainDestinations.SIGN_IN_ROUTE
//    ) {
//        //addHomeGraph(onPostSelected, onNavigateToRoute)
//    }
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
        SignUp()
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    KotlinAppTheme {
//        Greeting("Android")
//    }
//}