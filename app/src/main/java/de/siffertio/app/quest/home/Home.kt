package de.siffertio.app.quest.home

import HomeNavGraph
import HomeTransitions
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import de.siffertio.app.quest.ui.theme.QuestTheme

@Composable
@Destination(style = HomeTransitions::class)
@HomeNavGraph(start = true)
fun Home() {
  QuestTheme() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
          Text(text = "Home Screen")
        }
  }
}
