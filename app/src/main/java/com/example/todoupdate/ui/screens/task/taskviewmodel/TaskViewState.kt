package com.example.todoupdate.ui.screens.task.taskviewmodel

import com.example.todoupdate.data.models.Priority
import com.example.todoupdate.data.models.TaskData
import com.example.todoupdate.util.states.Action

data class TaskViewState (
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val priority: Priority = Priority.LOW,

    val actionTaskScreen: Action = Action.NO_ACTION,

    val selectedTask: TaskData? = null // RequestState<TaskData> = RequestState.Idle

)