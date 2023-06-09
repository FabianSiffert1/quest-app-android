package de.siffertio.app.quest.components.questComponents.ui.startQuest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ramcosta.composedestinations.annotation.Destination
import de.siffertio.app.quest.R
import de.siffertio.app.quest.components.questComponents.model.DefaultQuest
import de.siffertio.app.quest.components.questComponents.model.RepeatingQuest
import de.siffertio.app.quest.components.questComponents.model.WeekdayQuest
import de.siffertio.app.quest.components.questComponents.model.util.WeekDays
import de.siffertio.app.quest.components.questComponents.repositories.QuestRepository
import org.koin.androidx.compose.get

@Destination
@Composable
fun StartQuestScreen() {
    StartQuestContent()
}

@Composable
fun StartQuestContent(questRepository: QuestRepository = get()) {

    val tempDefaultQuestPlaceholder = stringResource(id = R.string.lorem_ipsum)
    Column(
        modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.surface),
        horizontalAlignment = CenterHorizontally
    ) {
        Text(text = "StartQuestScreen")
        Button(
            onClick = {
                questRepository.addQuestList(
                    mutableListOf(
                        DefaultQuest(questTitle = tempDefaultQuestPlaceholder),
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
            }
        ) {
            Text(text = "AddTestUsers")
        }
    }
}
