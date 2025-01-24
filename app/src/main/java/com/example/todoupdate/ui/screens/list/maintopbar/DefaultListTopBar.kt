package com.example.todoupdate.ui.screens.list.maintopbar

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.example.todoupdate.data.models.Priority
import com.example.todoupdate.ui.theme.topAppBarBackgroundColor
import com.example.todoupdate.ui.theme.topAppBarContentColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar(
    onSearchIconClicked: () -> Unit,
    onSortIconClicked: (Priority) -> Unit,
    onDeleteAllConfirmed: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {},
        actions = {},
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.topAppBarBackgroundColor,
            titleContentColor = MaterialTheme.colorScheme.topAppBarContentColor, // Title color
            navigationIconContentColor = MaterialTheme.colorScheme.topAppBarContentColor, // Icon color
            actionIconContentColor = MaterialTheme.colorScheme.topAppBarContentColor // Action icon color
        )
    )
}

@Composable
fun DefaultBarActions(
    onSearchIconClicked: () -> Unit,
    onSortIconClicked: (Priority) -> Unit,
    onDeleteAllConfirmed: () -> Unit
) {

}


