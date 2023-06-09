package de.siffertio.app.quest.home

import HomeNavGraph
import HomeTransitions
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import de.siffertio.app.quest.backendPlaceholder.PlaceholderQuestDatabaseImpl
import de.siffertio.app.quest.components.questComponents.ui.QuestLog
import de.siffertio.app.quest.ui.theme.QuestTheme
import org.koin.androidx.compose.koinViewModel

@Composable
@Destination(style = HomeTransitions::class)
@HomeNavGraph(start = true)
fun Home() {
    val viewModel = koinViewModel<HomeViewModel>()

    //    val questDatabase = viewModel.questDatabase
    //    questDatabase.addQuestList(
    //        mutableListOf(
    //            DefaultQuest(questTitle = stringResource(id = R.string.lorem_ipsum)),
    //            RepeatingQuest(),
    //            WeekdayQuest(
    //                questDays =
    //                    listOf(
    //                        WeekDays.MONDAY,
    //                        WeekDays.TUESDAY,
    //                        WeekDays.WEDNESDAY,
    //                        WeekDays.THURSDAY,
    //                        WeekDays.FRIDAY,
    //                        WeekDays.SATURDAY,
    //                        WeekDays.SUNDAY
    //                    )
    //            )
    //        )
    //    )

    // HomeScreen(questDatabase = questDatabase)
}

@Composable
fun HomeScreen(questDatabase: PlaceholderQuestDatabaseImpl) {
    QuestTheme() {
        Column(modifier = Modifier.fillMaxSize().padding(32.dp)) {
            QuestLog(props = questDatabase.questList)
        }
    }
}
