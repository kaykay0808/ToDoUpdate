package com.example.todoupdate.ui.screens.list.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayAlertDialog(
    title: String, // Title?
    dialogMessage: String,
    openAlertDialog: Boolean,
    closeDialog: () -> Unit,
    onYesClicked: () -> Unit
) {

}

