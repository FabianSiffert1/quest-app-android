package de.siffertio.app.quest.home

import HomeNavGraph
import HomeTransitions
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import de.siffertio.app.quest.components.questComponents.TaskListItem
import de.siffertio.app.quest.ui.theme.QuestTheme

@Composable
@Destination(style = HomeTransitions::class)
@HomeNavGraph(start = true)
fun Home() {

  HomeScreen()
}

@Composable
fun HomeScreen() {
  val tempTaskList = listOf("TaskListItem 1", "TaskListItem 2", "TaskListItem 3")

  QuestTheme() {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
      Text(text = "Home Screen")
      Spacer(modifier = Modifier.padding(32.dp))
      tempTaskList.forEach { it -> TaskListItem(text = it) }
    }
  }
}
