package de.rbuchwald.basicstatecodelab.ui.screens.wellness

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import de.rbuchwald.basicstatecodelab.data.model.WellnessTask

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, isChecked: Boolean) {
        tasks.find { it.id == item.id }?.let { task ->
            task.isChecked = isChecked
        }
    }
}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
