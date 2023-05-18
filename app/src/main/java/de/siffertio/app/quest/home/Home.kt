package de.siffertio.app.quest.home

import HomeNavGraph
import HomeTransitions
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import de.siffertio.app.quest.components.questTaskComponents.model.QuestLogItemClass
import de.siffertio.app.quest.components.questTaskComponents.model.QuestTypes
import de.siffertio.app.quest.components.questTaskComponents.ui.QuestLog
import de.siffertio.app.quest.ui.theme.QuestTheme

@Composable
@Destination(style = HomeTransitions::class)
@HomeNavGraph(start = true)
fun Home() {

  HomeScreen()
}

@Composable
fun HomeScreen() {
  val tempTaskList =
      listOf(
          QuestLogItemClass(
              questTitle = "Quest 1",
              questIcon = Icons.Default.DateRange,
              questType = QuestTypes.DEFAULT),
          QuestLogItemClass(
              questTitle = "Quest 2",
              questIcon = Icons.Default.Refresh,
              questType = QuestTypes.REPEATING),
          QuestLogItemClass(
              questTitle = "Quest 3",
              questIcon = Icons.Default.Info,
              questType = QuestTypes.SHARED),
          QuestLogItemClass(questTitle = "Quest 4", questIcon = Icons.Default.List))

  QuestTheme() {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
      Text(text = "Home Screen")
      Spacer(modifier = Modifier.padding(32.dp))
      QuestLog(props = tempTaskList)
    }
  }
}
