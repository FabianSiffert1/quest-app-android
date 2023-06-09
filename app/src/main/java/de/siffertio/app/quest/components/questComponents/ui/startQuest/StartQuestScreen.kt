package de.siffertio.app.quest.components.questComponents.ui.startQuest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import de.siffertio.app.quest.R
import de.siffertio.app.quest.components.questComponents.model.DefaultQuest
import de.siffertio.app.quest.components.questComponents.model.Quest
import de.siffertio.app.quest.components.questComponents.model.QuestType
import de.siffertio.app.quest.components.questComponents.model.RepeatingQuest
import de.siffertio.app.quest.components.questComponents.model.WeekdayQuest
import de.siffertio.app.quest.components.questComponents.model.util.WeekDays
import de.siffertio.app.quest.components.questComponents.repositories.QuestRepository
import de.siffertio.app.quest.components.questComponents.ui.startQuest.questSetup.DefaultQuestSetup
import de.siffertio.app.quest.components.questComponents.ui.startQuest.questSetup.GenericQuestSetup
import de.siffertio.app.quest.components.questComponents.ui.startQuest.questTypeToggle.QuestTypeToggle
import org.koin.androidx.compose.get

@Destination
@Composable
fun StartQuestScreen() {
    // TODO: Implement ViewModel
    StartQuestContent()
}

@Composable
fun StartQuestContent(questRepository: QuestRepository = get()) {

    val tempDefaultQuestPlaceholder = stringResource(id = R.string.lorem_ipsum)
    val selectedQuestType: MutableState<QuestType> = remember { mutableStateOf(QuestType.DEFAULT) }
    val currentQuest: MutableState<Quest> = remember { mutableStateOf(DefaultQuest()) }
    Column(
        modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.surface),
        horizontalAlignment = CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(top = 128.dp))
        QuestTypeToggle(selectedQuestType = selectedQuestType)
        Spacer(modifier = Modifier.padding(24.dp))

        GenericQuestSetup(currentQuest.value)
        Spacer(modifier = Modifier.padding(24.dp))

        when (selectedQuestType.value) {
            QuestType.DEFAULT -> {
                currentQuest.value = DefaultQuest()
                DefaultQuestSetup(currentQuest.value as DefaultQuest)
            }
            QuestType.REPEATING -> {
                Text(text = currentQuest.value.title)
                currentQuest.value = RepeatingQuest()
            }
            QuestType.WEEKDAY -> {
                Text(text = currentQuest.value.title)
                currentQuest.value = WeekdayQuest()
            }
        }
        Spacer(modifier = Modifier.padding(24.dp))
        Button(onClick = { addQuests(tempString = tempDefaultQuestPlaceholder, questRepository) }) {
            Text(text = "AddTestQuests")
        }
    }
}

fun addQuests(tempString: String, questRepository: QuestRepository) {
    questRepository.addQuestList(
        mutableListOf(
            DefaultQuest(title = tempString, completed = true),
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
