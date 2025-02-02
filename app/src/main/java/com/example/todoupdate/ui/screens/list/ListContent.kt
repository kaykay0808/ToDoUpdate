package com.example.todoupdate.ui.screens.list

import androidx.compose.runtime.Composable
import com.example.todoupdate.data.models.TaskData
import com.example.todoupdate.util.states.Action
import com.example.todoupdate.util.states.RequestState
import com.example.todoupdate.util.states.SearchAppBarState

@Composable
fun ListContent(
    allTask: RequestState<List<TaskData>>,
    searchedTask: RequestState<List<TaskData>>,
    searchAppBarState: SearchAppBarState,
    onSwipeToDelete: (Action, TaskData) -> Unit,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {

}
