package de.rbuchwald.basicstatecodelab.data.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class WellnessTask(
    val id: Int,
    val label: String,
    initialChecked: Boolean = false
    // var isChecked: MutableState<Boolean> = mutableStateOf(false)
) {
    var isChecked by mutableStateOf(initialChecked)
}