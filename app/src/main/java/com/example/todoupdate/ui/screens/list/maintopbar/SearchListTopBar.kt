package com.example.todoupdate.ui.screens.list.maintopbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoupdate.R
import com.example.todoupdate.ui.theme.SEARCH_BAR_ELEVATION
import com.example.todoupdate.ui.theme.TOP_APP_BAR_HEIGHT
import com.example.todoupdate.ui.theme.topAppBarBackgroundColor
import com.example.todoupdate.ui.theme.topAppBarContentColor

@Composable
fun SearchAppBar(
    textSearchInput: String,
    onSearchTextChange: (String) -> Unit,
    onCloseIconClicked: () -> Unit,
    onSearchImeClicked: (String) -> Unit, // When we actually search something (on the app keyboard)
    isIconEnabled: Boolean
    // viewState: ToDoViewState,
) {
    // A controller that makes the keyboard close after we click the searchButton
    val keyboardController = LocalSoftwareKeyboardController.current
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(TOP_APP_BAR_HEIGHT),
        tonalElevation = SEARCH_BAR_ELEVATION,
        color = MaterialTheme.colorScheme.topAppBarBackgroundColor
    ) {
        TextField(
            value = textSearchInput,
            onValueChange = { onSearchTextChange(it) },
            placeholder = {
                Text(
                    modifier = Modifier
                        .alpha(0.6f),
                    text = stringResource(id = R.string.search_input_placeholder),
                    color = Color.White
                )
            },
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.topAppBarContentColor,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    // opacity for the icon
                    modifier = Modifier.alpha(0.38f),
                    onClick = { }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(id = R.string.search_icon),
                        tint = MaterialTheme.colorScheme.topAppBarContentColor.copy(alpha = if (isIconEnabled) 1f else 0.38f)
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = onCloseIconClicked
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = stringResource(id = R.string.close_icon),
                        tint = MaterialTheme.colorScheme.topAppBarContentColor
                    )
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchImeClicked(textSearchInput)
                    keyboardController?.hide()
                }
            ),
            colors = TextFieldDefaults.colors(
                cursorColor = MaterialTheme.colorScheme.topAppBarContentColor,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                // This was removed: containerColor = Color.Transparent
            )
        )
    }
}

// unfocusedContainerColor = Color.Transparent, // ADD THIS
// disabledContainerColor = Color.Transparent,  // ADD THIS

@Preview
@Composable
fun SearchAppBarPreview() {
    SearchAppBar(
        textSearchInput = {"Hello"}.toString(),
        onSearchTextChange = {},
        onCloseIconClicked = {},
        onSearchImeClicked = {},
        isIconEnabled = true
    )
}
