package de.rbuchwald.basicstatecodelab.ui.screens.wellness

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import de.rbuchwald.basicstatecodelab.ui.components.StatefulWaterCounter
import de.rbuchwald.basicstatecodelab.ui.components.WellnessTasksList

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulWaterCounter(
            modifier = modifier.padding(horizontal = 8.dp)
        )

        WellnessTasksList(
            modifier = modifier.padding(horizontal = 8.dp),
            list = wellnessViewModel.tasks,
            onCheckedTask = { task, isChecked ->
                wellnessViewModel.changeTaskChecked(task, isChecked)
            },
            onClose = { task -> wellnessViewModel.remove(task) })
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessScreenPreview() {
    WellnessScreen()
}