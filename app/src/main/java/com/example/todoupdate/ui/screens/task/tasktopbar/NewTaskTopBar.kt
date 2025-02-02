package com.example.todoupdate.ui.screens.task.tasktopbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoupdate.R
import com.example.todoupdate.ui.theme.topAppBarBackgroundColor
import com.example.todoupdate.ui.theme.topAppBarContentColor
import com.example.todoupdate.util.states.Action

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTaskTopBar(
    navigateToListScreen: (Action) -> Unit
) {
    // Set Default state?

    // Designing the surface/topBar
    CenterAlignedTopAppBar(
        navigationIcon = { BackNavigationIcon(onBackClicked = navigateToListScreen)},
        title = {
            Text(
                text = stringResource(id = R.string.add_task),
                color = MaterialTheme.colorScheme.topAppBarContentColor
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.topAppBarBackgroundColor,
            titleContentColor = MaterialTheme.colorScheme.topAppBarContentColor, // Title color
            navigationIconContentColor = MaterialTheme.colorScheme.topAppBarContentColor, // Icon color
            actionIconContentColor = MaterialTheme.colorScheme.topAppBarContentColor // Action icon color

        ),
        actions = {
            AddAction(onAddClicked = navigateToListScreen)
        }

    )
}

@Composable
fun BackNavigationIcon(
    onBackClicked: (Action) -> Unit
) {
    IconButton(
        onClick = { onBackClicked(Action.NO_ACTION) }
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = stringResource(id = R.string.back_arrow),
            tint = MaterialTheme.colorScheme.topAppBarContentColor
        )
    }
}

@Composable
fun AddAction(
    onAddClicked: (Action) -> Unit
) {
    IconButton(onClick = { onAddClicked(Action.ADD) }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(id = R.string.add_task),
            tint = MaterialTheme.colorScheme.topAppBarContentColor
        )
    }
}

@Preview
@Composable
fun NewTaskAppBarPreview() {
    NewTaskTopBar(navigateToListScreen = {})
}
