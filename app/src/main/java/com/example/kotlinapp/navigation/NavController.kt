package com.example.kotlinapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


object MainDestinations {
    const val HOME_ROUTE = "home"
    const val POST_DETAIL_ROUTE = "post"
    const val POST_ID_KEY = "postId"

    const val SPLASHSCREEN_ROUTE = "splashScreen"
    const val SIGN_IN_ROUTE = "signIn"
    const val SIGN_UP_ROUTE = "signUp"
    const val EDIT_PROFILE_ROUTE = "editProfile"
    const val LANG_ROUTE = "lang"
    const val DEL_ACCOUNT_ROUTE = "delAccount"
    const val PRIVACY_ROUTE = "privacy"
    const val TERMS_CONDITIONS_ROUTE = "termCond"
    const val CREATE_POST_ROUTE = "createPost"
    const val PROFILE_DETAIL_ROUTE = "profile"
    const val SETTINGS_ROUTE = "settings"


}

/**
 * Remembers and creates an instance of [TripgramNavyController]
 */
@Composable
fun rememberNavController(
    navController: NavHostController = rememberNavController()
): NavController = remember(navController) {
    NavController(navController)
}

/**
 * Responsible for holding UI Navigation logic.
 */
@Stable
class NavController(
    val navController: NavHostController,
) {
    // ----------------------------------------------------------
    // Navigation state source of truth
    // ----------------------------------------------------------

    val currentRoute: String?
        get() = navController.currentDestination?.route

    fun upPress() {
        navController.navigateUp()
    }

    fun navigateToBottomBarRoute(route: String) {
        if (route != currentRoute) {
            navController.navigate(route) {
                launchSingleTop = true
                restoreState = true
                // Pop up backstack to the first destination and save state. This makes going back
                // to the start destination when pressing back in any other bottom tab.
                popUpTo(findStartDestination(navController.graph).id) {
                    saveState = true
                }
            }
        }
    }

    fun navigateToPostDetail(postId: Long, from: NavBackStackEntry) {
        // In order to discard duplicated navigation events, we check the Lifecycle
        if (from.lifecycleIsResumed()) {
            navController.navigate("${MainDestinations.POST_DETAIL_ROUTE}/$postId")
        }
    }

    fun navigateToSignIn(from: NavBackStackEntry) {
        if (from.lifecycleIsResumed()) {
            navController.navigate(MainDestinations.SIGN_IN_ROUTE)
        }
    }

    fun navigateToSignUp() {
        navController.navigate(MainDestinations.SIGN_UP_ROUTE)
    }
}

/**
 * If the lifecycle is not resumed it means this NavBackStackEntry already processed a nav event.
 *
 * This is used to de-duplicate navigation events.
 */
private fun NavBackStackEntry.lifecycleIsResumed() =
    this.lifecycle.currentState == Lifecycle.State.RESUMED

private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)

/**
 * Copied from similar function in NavigationUI.kt
 *
 * https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:navigation/navigation-ui/src/main/java/androidx/navigation/ui/NavigationUI.kt
 */
private tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}