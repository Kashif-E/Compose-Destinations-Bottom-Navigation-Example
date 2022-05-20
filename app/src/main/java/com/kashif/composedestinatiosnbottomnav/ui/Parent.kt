package com.kashif.composedestinatiosnbottomnav.ui

import android.annotation.SuppressLint
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.compose.rememberNavController

import com.kashif.composedestinatiosnbottomnav.ui.bottomnav_entries.BottomBarDestination
import com.kashif.composedestinatiosnbottomnav.ui.destinations.Destination
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.navigate

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Parent() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }

    ) {
        DestinationsNavHost(
            navController = navController,
            navGraph = NavGraphs.root
        )
    }
}

@SuppressLint("ResourceType")
@Composable
fun BottomBar(
    navController: NavController
) {
    val currentDestination: Destination = navController.appCurrentDestinationAsState().value
        ?: NavGraphs.root.startAppDestination

    //if you are using material 2 then you  should use  bottom navigation bar
    NavigationBar {
        BottomBarDestination.values().forEach { destination ->
            //similarly with material 2  use bottom nav item
            NavigationBarItem(
                selected = currentDestination == destination.direction,
                onClick = {
                    navController.navigate(destination.direction) {
                        launchSingleTop = true
                        val navigationRoutes = BottomBarDestination.values()

                        val firstBottomBarDestination = navController.backQueue
                            .firstOrNull {navBackStackEntry -> checkForDestinations(navigationRoutes, navBackStackEntry) }
                            ?.destination
                        // remove all navigation items from the stack
                        // so only the currently selected screen remains in the stack
                        if (firstBottomBarDestination != null) {
                            popUpTo(firstBottomBarDestination.id) {
                                inclusive = true
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        destination.icon,
                        contentDescription = stringResource(destination.label)
                    )
                },
                label = { Text(stringResource(destination.label)) },
            )
        }
    }
}

fun checkForDestinations(
    navigationRoutes: Array<BottomBarDestination>,
    navBackStackEntry: NavBackStackEntry
): Boolean {
    navigationRoutes.forEach {
        if (it.direction.route == navBackStackEntry.destination.route){
            return  true
        }

    }
    return false
}
