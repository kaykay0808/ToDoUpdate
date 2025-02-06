package com.example.todoupdate.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.todoupdate.navigation.Screen
import com.example.todoupdate.ui.screens.list.ListScreen

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    composable<Screen.List>/*(
        route = LIST_SCREEN,
        arguments = listOf(
            navArgument(LIST_ARGUMENT_KEY) {
                type = NavType.StringType
                defaultValue = Action.NO_ACTION.name // Todo: May cause some problems
            }
        )
    )*/ { navBackStackEntry ->
        // val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()
        // Log.d("ListComposable", action.name)
        ListScreen(
            //action = action,
            navigateToTaskScreen = navigateToTaskScreen
        )
    }
}
