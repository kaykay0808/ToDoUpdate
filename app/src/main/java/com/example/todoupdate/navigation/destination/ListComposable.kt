package com.example.todoupdate.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.todoupdate.navigation.Screen
import com.example.todoupdate.ui.screens.list.ListScreen

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    composable<Screen.List> { ListScreen(navigateToTaskScreen = navigateToTaskScreen) }
}
