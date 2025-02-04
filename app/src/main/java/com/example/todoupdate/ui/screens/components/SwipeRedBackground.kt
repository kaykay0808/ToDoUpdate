package com.example.todoupdate.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoupdate.R
import com.example.todoupdate.ui.theme.EXTRA_LARGE_PADDING
import com.example.todoupdate.ui.theme.HighPriorityColor

@Composable
fun SwipeRedBackground(degrees: Float/*Passing some icon rotation*/) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(HighPriorityColor)
            .padding(horizontal = EXTRA_LARGE_PADDING),
        // assigning an icon position
        contentAlignment = Alignment.CenterEnd
    ) {
        Icon(
            modifier = Modifier.rotate(degrees = degrees), // <- Passing some Icon rotation
            imageVector = Icons.Filled.Delete,
            contentDescription = stringResource(id = R.string.delete_icon),
            tint = Color.White
        )
    }
}

@Preview
@Composable
fun SwipeRedBackgroundPreview() {
    Column(modifier = Modifier.height(100.dp)) {
        SwipeRedBackground(degrees = 0f)
    }
}