package de.rbuchwald.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StatefulWaterCounter(
    modifier: Modifier = Modifier
) {
    var glassCount by rememberSaveable { mutableStateOf(0) }

    StatelessWaterCounter(
        modifier = modifier,
        drinkType = "water",
        glassCount = glassCount,
        onIncrementCount = { glassCount += 1 },
        onResetCountAndShowTask = { glassCount = 0 },
    )
}

@Composable
fun StatelessWaterCounter(
    modifier: Modifier = Modifier,
    drinkType: String,
    glassCount: Int,
    onIncrementCount: () -> Unit,
    onResetCountAndShowTask: () -> Unit,
) {
    Column(modifier = modifier
        .fillMaxWidth()
    ) {
        if (glassCount > 0) {
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 24.dp, end = 16.dp),
                text = if (glassCount == 1)
                    "You've had $glassCount glass of water."
                else
                    "You've had $glassCount glasses of water.",
            )
        }
        Row {
            Button(
                modifier = Modifier.padding(16.dp),
                onClick = onIncrementCount,
                enabled = glassCount < 10
            ) {
                Text("Add one")
            }
            Button(
                modifier = Modifier.padding(16.dp),
                enabled = glassCount != 0,
                onClick = onResetCountAndShowTask
            ) {
                Text(text = "Clear $drinkType count")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StatefulWaterCounterPreview() {
    StatefulWaterCounter()
}