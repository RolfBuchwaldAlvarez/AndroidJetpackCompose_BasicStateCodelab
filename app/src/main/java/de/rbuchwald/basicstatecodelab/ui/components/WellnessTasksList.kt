package de.rbuchwald.basicstatecodelab.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.rbuchwald.basicstatecodelab.data.model.WellnessTask

@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onClose: (WellnessTask) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(
            items = list,
            key = { task -> task.id }
        ) { task ->
            StatefulWellnessTaskItem(
                taskName = task.label,
                isChecked = task.isChecked,
                onCheckedChange = { isChecked -> onCheckedTask(task, isChecked) },
                onClose = { onClose(task) }
            )
        }
    }
}
