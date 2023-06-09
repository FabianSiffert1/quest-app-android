package de.siffertio.app.quest.components.questComponents.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.siffertio.app.quest.components.questComponents.model.DefaultQuest
import de.siffertio.app.quest.components.questComponents.model.Quest

@Composable
fun QuestLog(questList: List<Quest>) {
    Column() {
        LazyColumn(
            modifier = Modifier.weight(1f).padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(1) {
                Spacer(modifier = Modifier.padding(top = 24.dp))
                if (questList.isEmpty()) {
                    QuestLogItem(quest = DefaultQuest(title = "Add a Quest!"))
                }
                questList.forEach { prop ->
                    QuestLogItem(quest = prop)
                    Spacer(modifier = Modifier.padding(bottom = 30.dp))
                }
            }
        }
    }
}
