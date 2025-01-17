package com.example.todoupdate.ui.screens.list.maintopbar

import androidx.compose.runtime.Composable
import com.example.todoupdate.data.models.Priority
import com.example.todoupdate.ui.screens.list.listviewmodel.ListViewState

@Composable
fun ListTopBar(
    viewState: ListViewState,
    onSearchIconClicked: () -> Unit,
    onSortIconClicked: (Priority) -> Unit,
    onCloseIconClicked: () -> Unit,
    onSearchImeClicked: (String) -> Unit,
    onSearchTextChange: (String) -> Unit,
    onDeleteAllConfirmed: () -> Unit,
    textSearchInput: String
    // toDoViewModel: ToDoViewModel,
    // searchAppBarState: SearchAppBarState,
    // searchTextState: String // ->
) {

}
