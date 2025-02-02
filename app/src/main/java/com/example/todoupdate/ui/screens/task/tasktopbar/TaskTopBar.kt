package com.example.todoupdate.ui.screens.task.tasktopbar

import androidx.compose.runtime.Composable
import com.example.todoupdate.data.models.TaskData
import com.example.todoupdate.util.states.Action

@Composable
fun TaskTopBar(
    selectedTask: TaskData?,
    navigateToListScreen: (Action) -> Unit
) {
    if (selectedTask == null) {
        NewTaskTopBar(navigateToListScreen = navigateToListScreen)
    } else {
        ExistingTaskTopBar(
            selectedTask = selectedTask,
            navigateToListScreens = navigateToListScreen
        )
    }
}

