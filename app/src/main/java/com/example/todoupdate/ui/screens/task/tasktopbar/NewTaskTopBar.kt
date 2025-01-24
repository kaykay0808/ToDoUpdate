package com.example.todoupdate.ui.screens.task.tasktopbar

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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
        navigationIcon = {},
        title = {},
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.topAppBarBackgroundColor,
            titleContentColor = MaterialTheme.colorScheme.topAppBarContentColor, // Title color
            navigationIconContentColor = MaterialTheme.colorScheme.topAppBarContentColor, // Icon color
            actionIconContentColor = MaterialTheme.colorScheme.topAppBarContentColor // Action icon color

        ),
        actions = {}

    )
}

@Preview
@Composable
fun NewTaskAppBarPreview() {
    NewTaskTopBar(navigateToListScreen = {})
}
