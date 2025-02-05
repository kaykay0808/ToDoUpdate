package com.example.todoupdate.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todoupdate.ui.screens.list.ListScreen
import com.example.todoupdate.util.Constants.LIST_ARGUMENT_KEY
import com.example.todoupdate.util.Constants.LIST_SCREEN
import com.example.todoupdate.util.states.Action
import com.example.todoupdate.util.states.toAction

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(
            navArgument(LIST_ARGUMENT_KEY) {
                type = NavType.StringType
                defaultValue = Action.NO_ACTION.name // Todo: May cause some problems
            }
        )
    ) { navBackStackEntry ->
        val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()
        //Log.d("ListComposable", action.name)
        ListScreen(
            //action = action,
            navigateToTaskScreen = navigateToTaskScreen
        )
    }
}
