package de.siffertio.app.quest.settings

import SettingsNavGraph
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import de.siffertio.app.quest.settings.animations.SettingsTransitions
import de.siffertio.app.quest.ui.theme.QuestTheme

@Composable
@Destination(style = SettingsTransitions::class)
@SettingsNavGraph(start = true)
fun Settings() {
  QuestTheme() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
          Text(text = "Settings Screen")
        }
  }
}
