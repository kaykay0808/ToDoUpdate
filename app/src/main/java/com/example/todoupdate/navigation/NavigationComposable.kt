package com.example.todoupdate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.todoupdate.navigation.destination.listComposable
import com.example.todoupdate.navigation.destination.taskComposable

/** NavHost */
// Settings for our navigation
@Composable
fun NavigationSetup(
    navController: NavHostController
) {
    // val screen = remember(navController) { ScreenHolder(navController = navController) }
    /** NavHost */
    NavHost(
        navController = navController,
        startDestination = Screen.List()
    ) {
        /** NavGraph */
        /** NavGraph */

        // Define our composable build (we will create our custom destination instead of define our composable below)
        // navigateToTaskScreen = screen.listRoute,
        listComposable(
            navigateToTaskScreen = { taskId ->
                navController.navigate(Screen.Task(id = taskId))
            }
        )
        taskComposable(
            navigateToListScreen = { navController.popBackStack() }
        )
    }
}
