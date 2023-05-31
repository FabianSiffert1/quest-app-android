package de.siffertio.app.quest.home

import HomeNavGraph
import HomeTransitions
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import de.siffertio.app.quest.R
import de.siffertio.app.quest.components.questComponents.model.DefaultQuest
import de.siffertio.app.quest.components.questComponents.model.RepeatingQuest
import de.siffertio.app.quest.components.questComponents.model.WeekdayQuest
import de.siffertio.app.quest.components.questComponents.model.util.WeekDays
import de.siffertio.app.quest.components.questComponents.ui.QuestLog
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
            DefaultQuest(questTitle = stringResource(id = R.string.lorem_ipsum)),
            RepeatingQuest(),
            WeekdayQuest(questDays = listOf(WeekDays.MONDAY, WeekDays.TUESDAY))
        )

    QuestTheme() {
        Column(modifier = Modifier.fillMaxSize().padding(32.dp)) { QuestLog(props = tempTaskList) }
    }
}
