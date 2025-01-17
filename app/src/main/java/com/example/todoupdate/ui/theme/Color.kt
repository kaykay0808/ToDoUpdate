package com.example.todoupdate.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

// Priorities colors.
val LowPriorityColor = Color(0xFF00C980)
val MediumPriorityColor = Color(0xFFFFC114)
val HighPriorityColor = Color(0xFFFF4646)
val NonePriorityColor = Color(0xFF9C9C9C) // MediumGray?

/** -- TASK ITEM -- */
val ColorScheme.taskItemTextColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) LightGray else DarkGray

val ColorScheme.taskItemBackgroundColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) DarkGray else Color.White

/** -- TOP BAR -- */
val ColorScheme.topAppBarContentColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) LightGray else Color.White

val ColorScheme.topAppBarBackgroundColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Black else Purple500

/** -- FLOATING ACTION BUTTON -- */
val ColorScheme.floatingActionButtonBackgroundColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Purple700 else Teal200
