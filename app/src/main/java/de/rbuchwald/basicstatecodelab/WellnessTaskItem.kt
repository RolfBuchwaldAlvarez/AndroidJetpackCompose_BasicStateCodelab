package de.rbuchwald.basicstatecodelab

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StatefulWellnessTaskItem(
    modifier: Modifier = Modifier,
    taskName: String,
    onClose: () -> Unit
) {
    var isChecked by rememberSaveable { mutableStateOf(false) }
    // var hideOnClick by rememberSaveable { mutableStateOf(false) }

    StatelessWellnessTaskItem(
        modifier = modifier,
        isChecked = isChecked,
        taskName = taskName,
        onCheckedChange = { newValue -> isChecked = newValue },
        onClose = onClose
    )
}

@Composable
fun StatelessWellnessTaskItem(
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    taskName: String,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            text = taskName,
            modifier = Modifier
                .weight(1f)
        )
        Checkbox(checked = isChecked, onCheckedChange = onCheckedChange)
        IconButton(onClick = onClose) {
            Icon(imageVector = Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StatefulWellnessTaskItemPreview() {
    StatefulWellnessTaskItem(
        taskName = "Task # 0",
        onClose = {}
    )
}