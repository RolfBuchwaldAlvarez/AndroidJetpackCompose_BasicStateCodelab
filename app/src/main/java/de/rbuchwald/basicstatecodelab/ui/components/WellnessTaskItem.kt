package de.rbuchwald.basicstatecodelab.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp

@Composable
fun StatefulWellnessTaskItem(
    modifier: Modifier = Modifier,
    taskName: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit
) {
    // var isChecked by rememberSaveable { mutableStateOf(false) }
    StatelessWellnessTaskItem(
        modifier = modifier,
        isChecked = isChecked,
        taskName = taskName,
        onCheckedChange = onCheckedChange,
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
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        Text(
            text = taskName,
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.End
        ) {
            Checkbox(checked = isChecked, onCheckedChange = onCheckedChange)
            IconButton(onClick = onClose) {
                Icon(imageVector = Icons.Filled.Close, contentDescription = "Close")
            }
        }
    }
}