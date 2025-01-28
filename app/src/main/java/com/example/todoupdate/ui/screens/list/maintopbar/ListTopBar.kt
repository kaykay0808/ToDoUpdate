package com.example.todoupdate.ui.screens.list.maintopbar

import androidx.compose.runtime.Composable
import com.example.todoupdate.data.models.Priority
import com.example.todoupdate.ui.screens.list.listviewmodel.ListViewState
import com.example.todoupdate.util.states.SearchAppBarState

@Composable
fun ListTopBar(
    viewState: ListViewState,
    onSearchIconClicked: () -> Unit,
    onSortIconClicked: (Priority) -> Unit,
    onDeleteAllConfirmed: () -> Unit,
    textSearchInput: String,
    onCloseIconClicked: () -> Unit,
    onSearchImeClicked: (String) -> Unit,
    onSearchTextChange: (String) -> Unit,
    isIconEnabled: Boolean
    // toDoViewModel: ToDoViewModel,
    // searchAppBarState: SearchAppBarState,
    // searchTextState: String // ->
) {
    when(viewState.searchAppBarState) {
        SearchAppBarState.CLOSED -> {
            DefaultListAppBar(
                onSearchIconClicked= onSearchIconClicked,
                onSortIconClicked = onSortIconClicked,
                onDeleteAllConfirmed = onDeleteAllConfirmed
            )
        }
        else-> {
            SearchAppBar(
                textSearchInput = textSearchInput,
                onCloseIconClicked = onCloseIconClicked,
                onSearchTextChange = onSearchTextChange,
                onSearchImeClicked = onSearchImeClicked,
                isIconEnabled = isIconEnabled,
            )
        }
    }
}
