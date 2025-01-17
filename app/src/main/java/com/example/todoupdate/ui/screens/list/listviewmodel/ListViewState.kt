package com.example.todoupdate.ui.screens.list.listviewmodel

import com.example.todoupdate.data.models.TaskData
import com.example.todoupdate.util.states.Action
import com.example.todoupdate.util.states.CloseIconState
import com.example.todoupdate.util.states.RequestState
import com.example.todoupdate.util.states.SearchAppBarState

data class ListViewState(
    // Top bar
    val searchAppBarState: SearchAppBarState = SearchAppBarState.CLOSED,
    val searchTextInputState: String = "",
    val closeIconState: CloseIconState = CloseIconState.READY_TO_EMPTY_FIELD,
    // Room
    val allTask: RequestState<List<TaskData>> = RequestState.Idle, // List<TaskData> = emptyList()
    val actionForSnackBar: Action = Action.NO_ACTION,
    val searchTask: RequestState<List<TaskData>> = RequestState.Idle
)
