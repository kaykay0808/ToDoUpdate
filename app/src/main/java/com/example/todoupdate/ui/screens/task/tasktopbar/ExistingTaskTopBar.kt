package com.example.todoupdate.ui.screens.task.tasktopbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoupdate.R
import com.example.todoupdate.data.models.Priority
import com.example.todoupdate.data.models.TaskData
import com.example.todoupdate.ui.screens.components.DisplayAlertDialog
import com.example.todoupdate.ui.theme.topAppBarBackgroundColor
import com.example.todoupdate.ui.theme.topAppBarContentColor
import com.example.todoupdate.util.states.Action

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExistingTaskTopBar(
    selectedTask: TaskData,
    navigateToListScreens: (Action) -> Unit
) {
    CenterAlignedTopAppBar(
        navigationIcon = {
            CloseAction(onCloseClicked = navigateToListScreens)
        },
        title = {
            Text(
                text = stringResource(id = R.string.task)
            )
        },
        actions = {
            ExistingTaskBarActions(
                selectedTask = selectedTask,
                navigateToListScreens = navigateToListScreens
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.topAppBarBackgroundColor,
            titleContentColor = MaterialTheme.colorScheme.topAppBarContentColor, // Title color
            navigationIconContentColor = MaterialTheme.colorScheme.topAppBarContentColor, // Icon color
            actionIconContentColor = MaterialTheme.colorScheme.topAppBarContentColor // Action icon color
        )
    )
}
// Navigation button
@Composable
fun CloseAction(onCloseClicked: (Action) -> Unit) {
    IconButton(
        onClick = { onCloseClicked(Action.NO_ACTION) }
    ) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = stringResource(id = R.string.close_icon),
            tint = MaterialTheme.colorScheme.topAppBarContentColor
        )
    }
}

@Composable
fun ExistingTaskBarActions(
    selectedTask: TaskData,
    navigateToListScreens: (Action) -> Unit
) {
    var openAlertDialog by remember {
        mutableStateOf(false)
    }
    DisplayAlertDialog(
        title = stringResource(
            id = R.string.delete_task,
            selectedTask.title
        ),
        dialogMessage = stringResource(
            id = R.string.delete_task_confirmation,
            selectedTask.title
        ),
        openAlertDialog = openAlertDialog,
        closeDialog = { openAlertDialog = false },
        onYesClicked = { }
    )
    DeleteAction(
        onDeleteClicked = { openAlertDialog = true }
    )
    UpdateAction(
        onUpdateClicked = navigateToListScreens
    )
}

/** --------------------------- Button Actions ------------------------------------ */

@Composable
fun DeleteAction(onDeleteClicked: () -> Unit) {
    IconButton(onClick = { onDeleteClicked() }) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = stringResource(id = R.string.delete_icon),
            tint = MaterialTheme.colorScheme.topAppBarContentColor
        )
    }
}

@Composable
fun UpdateAction(onUpdateClicked: (Action) -> Unit) {
    IconButton(onClick = { onUpdateClicked(Action.UPDATE) }) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_icon),
            tint = MaterialTheme.colorScheme.topAppBarContentColor
        )
    }
}

@Preview
@Composable
fun ExistingTaskTopBarPreview() {
    ExistingTaskTopBar(
        selectedTask = TaskData(
            0,
            "Task Title",
            "Some Description",
            Priority.HIGH
        ),
        navigateToListScreens = {}
    )
}

