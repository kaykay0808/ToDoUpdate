package com.example.todoupdate.navigation.destination

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.todoupdate.navigation.Screen
import com.example.todoupdate.ui.screens.task.TaskScreen

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (/*Action*/) -> Unit
) {
    composable<Screen.Task>(
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { fullWidth ->
                    -fullWidth
                },
                animationSpec = tween(durationMillis = 400) // Animation time
            )
        }
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.toRoute<Screen.Task>().id
        TaskScreen(
            navigateToListScreen = navigateToListScreen,
            taskId = taskId
        )
    }
}
