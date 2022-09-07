package de.rbuchwald.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        StatefulWaterCounter(modifier = Modifier.padding(16.dp))

        val list = remember { getWellnessTasks().toMutableStateList() }
        WellnessTasksList(
            modifier = modifier.padding(horizontal = 8.dp),
            list = list,
            onCloseTask = { task -> list.remove(task) })
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessScreenPreview() {
    WellnessScreen()
}