package de.siffertio.app.quest.components.questComponents.ui

import androidx.compose.runtime.Composable
import de.siffertio.app.quest.components.questComponents.model.DefaultQuest
import de.siffertio.app.quest.components.questComponents.model.QuestTypes
import de.siffertio.app.quest.components.questComponents.model.RepeatingQuest
import de.siffertio.app.quest.components.questComponents.model.WeekdayQuest
import de.siffertio.app.quest.components.questComponents.ui.questLogComponents.DefaultQuestComponent
import de.siffertio.app.quest.components.questComponents.ui.questLogComponents.RepeatingQuestComponent
import de.siffertio.app.quest.components.questComponents.ui.questLogComponents.WeekdayQuestComponent

@Composable
fun QuestLogItem(props: QuestTypes) {
    val maximumCharacters = 90
    val cutOffString =
        if (props.questTitle.length > maximumCharacters) {
            props.questTitle.substring(0, maximumCharacters) + " ..."
        } else props.questTitle
    props.questTitle = cutOffString
    when (props) {
        is DefaultQuest -> DefaultQuestComponent(props = props)
        is RepeatingQuest -> RepeatingQuestComponent(props = props)
        is WeekdayQuest -> {
            WeekdayQuestComponent(props = props)
        }
    }
}
