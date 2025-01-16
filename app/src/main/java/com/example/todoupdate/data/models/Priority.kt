package com.example.todoupdate.data.models

import androidx.compose.ui.graphics.Color
import com.example.todoupdate.ui.theme.HighPriorityColor
import com.example.todoupdate.ui.theme.LowPriorityColor
import com.example.todoupdate.ui.theme.MediumPriorityColor
import com.example.todoupdate.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}
