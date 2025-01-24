package com.example.todoupdate.ui.screens.list

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todoupdate.R
import com.example.todoupdate.ui.screens.ViewEffects
import com.example.todoupdate.ui.screens.list.listviewmodel.ListViewEffect
import com.example.todoupdate.ui.screens.list.listviewmodel.ListViewModel
import com.example.todoupdate.ui.theme.floatingActionButtonBackgroundColor
import com.example.todoupdate.util.states.Action

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    val listViewModel: ListViewModel = hiltViewModel()
    val viewState = listViewModel.viewState
    val allTask = viewState.allTask
    val scaffoldState = remember { SnackbarHostState() }
    // val scaffoldState = rememberSnackBarHost()

    ViewEffects(listViewModel.viewEffects) {
        when (it) {
            is ListViewEffect.ShowSnackBar -> if (it.action != Action.NO_ACTION) {
                val snackBarResult = scaffoldState.showSnackbar(
                    message = it.message,
                    actionLabel = listViewModel.returningActionToString(it.action)
                )
                listViewModel.undoDeletedTask(
                    action = it.action,
                    snackBarResult = snackBarResult,
                    onUndoClicked = it.onUndoClicked
                )
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = scaffoldState) },
        topBar = {},
        content = {},
        floatingActionButton = {
            ListFloatingActionButton(onFloatingActionButtonClicked = navigateToTaskScreen)
        }
    )
}

@Composable
fun ListFloatingActionButton(onFloatingActionButtonClicked: (taskId: Int) -> Unit) {
    FloatingActionButton(
        onClick = {},
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
