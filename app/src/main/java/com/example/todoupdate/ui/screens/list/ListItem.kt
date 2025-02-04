package com.example.todoupdate.ui.screens.list

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoupdate.data.models.Priority
import com.example.todoupdate.data.models.TaskData
import com.example.todoupdate.ui.theme.LARGE_PADDING
import com.example.todoupdate.ui.theme.PRIORITY_INDICATOR_SIZE
import com.example.todoupdate.ui.theme.TASK_ITEM_ELEVATION
import com.example.todoupdate.ui.theme.taskItemBackgroundColor
import com.example.todoupdate.ui.theme.taskItemTextColor

@Composable
fun ListItem(
    modifier: Modifier = Modifier,
    taskData: TaskData,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .clickable { navigateToTaskScreen(taskData.id) }
        ,
        color = MaterialTheme.colorScheme.taskItemBackgroundColor,
        shape = RectangleShape,
        shadowElevation = TASK_ITEM_ELEVATION,
    ) {
        Column(
            modifier = Modifier
                .padding(all = LARGE_PADDING)
                .fillMaxWidth()
        ) {
            Row {
                Text(
                    modifier = Modifier.weight(8f),
                    text = taskData.title,
                    color = MaterialTheme.colorScheme.taskItemTextColor,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Canvas(
                        modifier = Modifier
                            .size(PRIORITY_INDICATOR_SIZE)
                    ) {
                        drawCircle(
                            // Get priority color from our taskData.
                            color = taskData.priority.color
                        )
                    }
                }
            }
            // Description Text under the title.
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = taskData.description,
                color = MaterialTheme.colorScheme.taskItemTextColor,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis /* This value will give dots in the end of text if line is more then 2*/
            )
        }
    }
}

@Preview
@Composable
fun TaskItemPreview() {
    ListItem(
        taskData = TaskData(
            0,
            "This is a Random Title",
            "Very Hard Task",
            Priority.HIGH
        ),
        navigateToTaskScreen = {}
    )
}
