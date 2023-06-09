package de.siffertio.app.quest.components.questComponents.ui.startQuest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun StartQuestScreen() {
    StartQuestContent()
}

@Composable
fun StartQuestContent() {
    Column(
        modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.surface),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "StartQuestScreen")
    }
}
