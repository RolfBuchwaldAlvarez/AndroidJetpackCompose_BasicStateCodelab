package de.rbuchwald.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(
            items = list,
            key = { task -> task.id }
        ) { task ->
            StatefulWellnessTaskItem(
                taskName = task.label,
                onClose = { onCloseTask(task) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessTaskPreview() {
    WellnessTasksList(
        list = getWellnessTasks(),
        onCloseTask = {}
    )
}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }