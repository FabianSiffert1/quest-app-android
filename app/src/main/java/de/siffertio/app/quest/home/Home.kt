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
import de.siffertio.app.quest.components.questComponents.repositories.QuestRepository
import de.siffertio.app.quest.components.questComponents.ui.QuestLog
import de.siffertio.app.quest.ui.theme.QuestTheme
import org.koin.androidx.compose.koinViewModel

@Composable
@Destination(style = HomeTransitions::class)
@HomeNavGraph(start = true)
fun Home(viewModel: HomeViewModel = koinViewModel()) {

    val questDatabase = viewModel.questRepository

    println("1312312312")
    questDatabase.addQuestList(
        mutableListOf(
            DefaultQuest(questTitle = stringResource(id = R.string.lorem_ipsum)),
            RepeatingQuest(),
            WeekdayQuest(
                questDays =
                    listOf(
                        WeekDays.MONDAY,
                        WeekDays.TUESDAY,
                        WeekDays.WEDNESDAY,
                        WeekDays.THURSDAY,
                        WeekDays.FRIDAY,
                        WeekDays.SATURDAY,
                        WeekDays.SUNDAY
                    )
            )
        )
    )
    viewModel.printQuests()
    HomeScreen(questDatabase = questDatabase)
}

@Composable
fun HomeScreen(questDatabase: QuestRepository) {
    QuestTheme() {
        Column(modifier = Modifier.fillMaxSize().padding(32.dp)) {
            QuestLog(props = questDatabase.getQuests())
        }
    }
}
