package de.siffertio.app.quest.components.questComponents.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.siffertio.app.quest.components.questComponents.model.Quest

@Composable
fun QuestLog(props: List<Quest>) {
    Column() {
        LazyColumn(
            modifier = Modifier.weight(1f),
        ) {
            items(1) {
                Spacer(modifier = Modifier.padding(top = 24.dp))
                props.forEach { prop ->
                    QuestLogItem(props = prop)
                    Spacer(modifier = Modifier.padding(bottom = 30.dp))
                }
            }
        }
    }
}
