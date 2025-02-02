package com.example.todoupdate.ui.screens.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoupdate.R

@Composable
fun DisplayAlertDialog(
    title: String, // Title?
    dialogMessage: String,
    openAlertDialog: Boolean,
    closeDialog: () -> Unit,
    onYesClicked: () -> Unit
) {
    if (openAlertDialog) {
        AlertDialog(
            title = {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineSmall, //MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold
                )
            },
            // The text which presents the details regarding the Dialog's purpose
            text = {
                Text(
                    text = dialogMessage,
                    style = MaterialTheme.typography.bodyLarge,//MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Normal
                )
            },
            // Positive button
            confirmButton = {
                Button(
                    onClick = {
                        // onYesClicked will trigger {navigateToListScreen(Action.DELETE)} from ExistingTaskTopBar (TaskScreen)
                        // and {onDeleteAllConfirmed()}
                        onYesClicked()
                        closeDialog()
                    }
                ) {
                    Text(text = stringResource(id = R.string.yes))
                }
            },
            // Negative Button
            dismissButton = {
                OutlinedButton(
                    onClick = { closeDialog() }
                ) {
                    Text(text = stringResource(id = R.string.no))
                }
            },
            onDismissRequest = { closeDialog() }
        )

    }

}

@Preview
@Composable
fun DisplayAlertDialogPreview() {
    DisplayAlertDialog(
        title = "Alert Dialog Title",
        dialogMessage = "Alert Alert Alert are you sure?",
        openAlertDialog = true,
        closeDialog = {},
        onYesClicked = {}
    )
}

