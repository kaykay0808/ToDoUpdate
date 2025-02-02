package com.example.todoupdate.ui.screens.list.maintopbar

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoupdate.R
import com.example.todoupdate.data.models.Priority
import com.example.todoupdate.ui.screens.components.DisplayAlertDialog
import com.example.todoupdate.ui.screens.components.PriorityItem
import com.example.todoupdate.ui.theme.LARGE_PADDING
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
        title = {
            Text(
                text = stringResource(id = R.string.task),
                color = MaterialTheme.colorScheme.topAppBarContentColor
            )
        },
        actions = {
            DefaultBarActions(
                onSearchIconClicked = onSearchIconClicked,
                onSortIconClicked = onSortIconClicked,
                onDeleteAllConfirmed = onDeleteAllConfirmed
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

@Composable
fun DefaultBarActions(
    onSearchIconClicked: () -> Unit,
    onSortIconClicked: (Priority) -> Unit,
    onDeleteAllConfirmed: () -> Unit
) {
    var openAlertDialog by remember {
        mutableStateOf(false)
    }
    DisplayAlertDialog(
        title = stringResource(id = R.string.delete_all_task),
        dialogMessage = stringResource(id = R.string.delete_all_task_confirmation),
        openAlertDialog = openAlertDialog,
        closeDialog = {
            openAlertDialog = false
        },
        onYesClicked = { onDeleteAllConfirmed() }
    )
    SearchAction(onSearchIconClicked = onSearchIconClicked)
    SortAction(onSortIconClicked = onSortIconClicked)
    DeleteAllAction(onDeleteAllIconClicked = { openAlertDialog = true })
}

// action 1
@Composable
fun SearchAction(
    onSearchIconClicked: () -> Unit
) {
    // Define an Icon for the action
    IconButton(
        onClick = { onSearchIconClicked() }
    ) { // define the icon appearance
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.search_action),
            tint = MaterialTheme.colorScheme.topAppBarContentColor
        )
    }
}

// action 2
@Composable
fun SortAction(
    onSortIconClicked: (Priority) -> Unit
) {
    var expandedDropDownMenu by remember { mutableStateOf(false) }

    IconButton(
        onClick = { expandedDropDownMenu = true }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter_list),
            contentDescription = stringResource(id = R.string.sort_action),
            tint = MaterialTheme.colorScheme.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expandedDropDownMenu,
            onDismissRequest = { expandedDropDownMenu = false }
        ) {
            // Items are defined under the component package inside the PriorityItem file.
            Priority.entries.toTypedArray().slice(setOf(0, 2, 3)).forEach { priority ->
                DropdownMenuItem(
                    text = { PriorityItem(priority = priority) },
                    onClick = {
                        expandedDropDownMenu = false
                        onSortIconClicked(priority)
                    }
                )
            }

            // Item 1
            /*DropdownMenuItem(
                onClick = {
                    expandedDropDownMenu = false
                    onSortIconClicked(Priority.LOW)
                }
            ) {
                // Defining the row item
                PriorityItem(priority = Priority.LOW)
            }

            // Item 2
            DropdownMenuItem(
                onClick = {
                    expandedDropDownMenu = false
                    onSortIconClicked(Priority.HIGH)
                }
            ) {
                // Defining the row item
                PriorityItem(priority = Priority.HIGH)
            }

            // Item 3
            DropdownMenuItem(
                onClick = {
                    expandedDropDownMenu = false
                    onSortIconClicked(Priority.NONE)
                }
            ) {
                // Defining the row item
                PriorityItem(priority = Priority.NONE)
            }*/
        }
    }
}

// action 3
@Composable
fun DeleteAllAction(onDeleteAllIconClicked: () -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(
        onClick = {
            expanded = true
        }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_vertical_menu),
            contentDescription = stringResource(id = R.string.delete_all_action),
            tint = MaterialTheme.colorScheme.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = {
                    Text(
                        modifier = Modifier.padding(start = LARGE_PADDING),
                        text = stringResource(id = R.string.delete_all_action),
                        style = MaterialTheme.typography.titleSmall
                    )
                },
                onClick = {
                    expanded = false
                    onDeleteAllIconClicked()
                }
            )
        }
    }
}

@Preview
@Composable
fun DefaultListAppBarPreview() {
    DefaultListAppBar(
        onSearchIconClicked = {},
        onSortIconClicked = {},
        onDeleteAllConfirmed = {}
    )
}


