package com.example.todoupdate.ui.screens.task

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todoupdate.ui.screens.ViewEffects
import com.example.todoupdate.ui.screens.task.tasktopbar.TaskTopBar
import com.example.todoupdate.ui.screens.task.taskviewmodel.TaskViewEffects
import com.example.todoupdate.ui.screens.task.taskviewmodel.TaskViewModel
import com.example.todoupdate.util.states.Action

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskScreen(
    taskId: Int,
    navigateToListScreen: (/*Action*/) -> Unit
) {
    val taskViewModel: TaskViewModel = hiltViewModel()
    val taskViewState = taskViewModel.taskViewState
    val selectedTask = taskViewState.selectedTask
    val context = LocalContext.current

    LaunchedEffect(key1 = taskId) {
        taskViewModel.getSelectedTask(taskId = taskId)
    }
    LaunchedEffect(key1 = selectedTask) {
        if (selectedTask != null || taskId == -1) {
            taskViewModel.updateTaskField(selectedTask = selectedTask)
        }
    }

    ViewEffects(taskViewModel.viewEffects) {
        when (it) {
            TaskViewEffects.NavigateBack -> navigateToListScreen()
            TaskViewEffects.DisplayErrorToast -> displayToast(context = context)
        }
    }

    Log.d("TASK_SCREEN", "$selectedTask")
    Scaffold(
        topBar = {
            TaskTopBar(
                selectedTask = taskViewState.selectedTask,
                navigateToListScreen = { action ->
                    if (action == Action.NO_ACTION) {
                        navigateToListScreen()
                    } else {
                        taskViewModel.manageDatabaseAction(
                            action = action
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            TaskContent(
                modifier = Modifier.padding(paddingValues),
                title = taskViewState.title,
                description = taskViewState.description,
                priority = taskViewState.priority,
                onTitleChange = { taskViewModel.updateTitle(newTitle = it) },
                onDescriptionChange = { taskViewModel.updateDescription(newDescription = it) },
                onPriorityChange = { taskViewModel.updatePriority(newPriority = it) }
            )
        }
    )
}

// A Toast warning if fields are empty in the task screen
private fun displayToast(context: Context) {
    Toast.makeText(
        context,
        "Text fields empty, please fill in the title and the description",
        Toast.LENGTH_SHORT
    ).show()
}
