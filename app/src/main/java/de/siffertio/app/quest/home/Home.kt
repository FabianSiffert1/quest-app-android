package de.siffertio.app.quest.home

import HomeNavGraph
import HomeTransitions
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import de.siffertio.app.quest.components.questComponents.repositories.QuestRepository
import de.siffertio.app.quest.components.questComponents.ui.QuestLog
import de.siffertio.app.quest.ui.theme.QuestTheme
import org.koin.androidx.compose.koinViewModel

@Composable
@Destination(style = HomeTransitions::class)
@HomeNavGraph(start = true)
fun Home(viewModel: HomeViewModel = koinViewModel()) {

    val questDatabase = viewModel.questRepository
    HomeScreen(questDatabase = questDatabase)
}

@Composable
fun HomeScreen(questDatabase: QuestRepository) {
    QuestTheme() {
        Column(modifier = Modifier.fillMaxSize()) {
            QuestLog(questList = questDatabase.getQuests())
        }
    }
}
