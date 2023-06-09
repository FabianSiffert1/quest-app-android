package de.siffertio.app.quest.components.questComponents.ui.startQuest.questSetup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import de.siffertio.app.quest.components.questComponents.model.Quest

@Composable
fun GenericQuestSetup(quest: Quest) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = quest.title,
            onValueChange = { quest.title = it },
            label = { Text(text = "Quest Title") }
        )
    }
}
