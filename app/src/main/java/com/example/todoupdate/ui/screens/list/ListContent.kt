package com.example.todoupdate.ui.screens.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.example.todoupdate.data.models.TaskData
import com.example.todoupdate.ui.screens.components.SwipeRedBackground
import com.example.todoupdate.util.states.Action
import com.example.todoupdate.util.states.RequestState
import com.example.todoupdate.util.states.SearchAppBarState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ListContent(
    allTask: RequestState<List<TaskData>>,
    searchedTask: RequestState<List<TaskData>>,
    searchAppBarState: SearchAppBarState,
    onSwipeToDelete: (Action, TaskData) -> Unit,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    if (searchAppBarState == SearchAppBarState.TRIGGERED) {
        if (allTask is RequestState.Success) {

        }
    }
}

@Composable
fun HandleListContentState(
    taskFromList: List<TaskData>,
    onSwipeToDelete: (Action, TaskData) -> Unit,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    if (taskFromList.isEmpty()) {
        EmptyContent()
    } else {

    }
}

@Composable
fun DisplayTask(
    taskFromList: List<TaskData>,
    onSwipeToDelete: (Action, TaskData) -> Unit,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    val scope = rememberCoroutineScope()
    LazyColumn {
        items(
            items = taskFromList,
            key = { task ->
                task.id
            }
        ) { task ->
            val dismissState = rememberSwipeToDismissBoxState(
                confirmValueChange = { dismissDirection ->
                    if (dismissDirection == SwipeToDismissBoxValue.EndToStart) {
                        scope.launch {
                            delay(300)
                            onSwipeToDelete(Action.DELETE, task)

                        }
                        true
                    } else {
                        false
                    }
                }
            )
            val degrees by animateFloatAsState(
                targetValue = if (dismissState.targetValue == SwipeToDismissBoxValue.Settled) 0f else -45f,
                label = "Animation"
            )
            // Animation
            var itemAppeared by remember { mutableStateOf(false) }
            LaunchedEffect(key1 = true) {
                itemAppeared = true
            }
            AnimatedVisibility(
                visible = itemAppeared,
                enter = expandVertically(animationSpec = tween(300)),
                exit = shrinkVertically(animationSpec = tween(300))
            ) {
                SwipeToDismissBox(
                    state = dismissState,
                    enableDismissFromStartToEnd = false, // Only allow EndToStart swipe
                    backgroundContent = {
                        SwipeRedBackground(degrees = degrees)
                    },
                    content = {
                        /*TaskItem(
                            modifier = Modifier.animateItemPlacement(),
                            taskData = task,
                            navigateToTaskScreen = navigateToTaskScreen
                        )*/
                    }
                )

            }
        }
    }
}

