package de.siffertio.app.quest.components.questComponents.ui.startQuest.questSetup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import de.siffertio.app.quest.components.questComponents.model.DefaultQuest

@Composable
fun DefaultQuestSetup(quest: DefaultQuest) {
    val taskList = remember { quest.tasks }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
            items(1) { taskList?.forEach { task -> Text(text = task.description) } }
        }
    }
    Button(onClick = { taskSetup(quest) }) { Text(text = "ChangeTaskDescription") }
}

fun taskSetup(quest: DefaultQuest) {
    quest.tasks?.forEach { task -> println(task.description) }
}
