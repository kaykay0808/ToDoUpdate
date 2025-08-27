package com.example.todoupdate.ui.screens.list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todoupdate.R
import com.example.todoupdate.ui.screens.ViewEffects
import com.example.todoupdate.ui.screens.list.listviewmodel.ListViewEffect
import com.example.todoupdate.ui.screens.list.listviewmodel.ListViewModel
import com.example.todoupdate.ui.screens.list.maintopbar.ListTopBar
import com.example.todoupdate.ui.theme.floatingActionButtonBackgroundColor
import com.example.todoupdate.util.states.Action
import com.example.todoupdate.util.states.SearchAppBarState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    val listViewModel: ListViewModel = hiltViewModel()
    val viewState = listViewModel.viewState
    val allTask = viewState.allTask
    val scaffoldState = remember { SnackbarHostState() }

    ViewEffects(listViewModel.viewEffects) {
        when (it) {
            is ListViewEffect.ShowSnackBar -> if (it.action != Action.NO_ACTION) {
                val snackBarResult = scaffoldState.showSnackbar(
                    message = it.message,
                    actionLabel = listViewModel.returningActionToString(it.action),
                    duration = SnackbarDuration.Short
                )
                // If user clicked on the snackBar action and the Action is Delete.
                listViewModel.undoDeletedTaskFromSnackBar(
                    snackBarResult = snackBarResult,
                    action = it.action,
                    onUndoClicked = it.onUndoClicked
                )
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = scaffoldState) },
        topBar = {
            ListTopBar(
                viewState = viewState,
                onSearchIconClicked = {
                    listViewModel.listAppBarState(
                        newState = SearchAppBarState.OPENED
                    )
                },
                onSortIconClicked = {
                    listViewModel.persistSortState(it)
                },
                onDeleteAllConfirmed = {
                    listViewModel.deleteAllTask()
                    listViewModel.setActions()

                },
                textSearchInput = viewState.searchTextInputState,
                onCloseIconClicked = {
                    listViewModel.handleCloseIconClicked()
                },
                onSearchImeClicked = { searchQuery ->
                    listViewModel.searchDatabase(searchQuery = searchQuery)
                },
                onSearchTextChange = { onNewTextEdit ->
                    listViewModel.newInputTextChange(onNewTextEdit)
                },
                isIconEnabled = viewState.iconEnableState // todo: may fix this
            )
        },
        content = { paddingValues ->
            ListContent(
                modifier = Modifier.padding(paddingValues),
                allTask = allTask,
                searchedTask = viewState.allTask, // <-do we need this
                searchAppBarState = viewState.searchAppBarState,
                onSwipeToDelete = { action, taskData ->
                    listViewModel.updateAction(newAction = action) // todo: do we need this line?
                    listViewModel.deleteSingleTaskFromList(taskData = taskData)
                },
                navigateToTaskScreen = navigateToTaskScreen

            )
        },
        floatingActionButton = {
            ListFloatingActionButton(onFloatingActionButtonClicked = navigateToTaskScreen)
        }
    )
}

@Composable
fun ListFloatingActionButton(onFloatingActionButtonClicked: (taskId: Int) -> Unit) {
    FloatingActionButton(
        onClick = {
            onFloatingActionButtonClicked(-1)
        },
        containerColor = MaterialTheme.colorScheme.floatingActionButtonBackgroundColor

    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_button),
            tint = Color.Black
        )
    }
}

@Preview
@Composable
fun ListFloatingActionButtonPreview() {
    ListFloatingActionButton(
        onFloatingActionButtonClicked = {}
    )
}
