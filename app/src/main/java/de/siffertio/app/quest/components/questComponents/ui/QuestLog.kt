package de.siffertio.app.quest.components.questComponents.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.siffertio.app.quest.components.questComponents.model.QuestBaseClass

@Composable
fun QuestLog(props: List<QuestBaseClass>) {
    Column() {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(1) { props.forEach { prop -> QuestLogItem(props = prop) } }
        }
    }
}
