package de.siffertio.app.quest.components.questComponents.ui

import QuestTypeColors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.siffertio.app.quest.components.questComponents.model.DefaultQuest
import de.siffertio.app.quest.components.questComponents.model.QuestTypes
import de.siffertio.app.quest.components.questComponents.model.RepeatingQuest
import de.siffertio.app.quest.components.questComponents.model.WeekdayQuest
import de.siffertio.app.quest.components.questComponents.ui.questTypeComponents.DefaultQuestComponent
import de.siffertio.app.quest.components.questComponents.ui.questTypeComponents.RepeatingQuestComponent
import de.siffertio.app.quest.components.questComponents.ui.questTypeComponents.WeekdayQuestComponent

@Composable
fun Quest(props: QuestTypes) {
    Row(
        modifier =
            Modifier.fillMaxWidth(1f)
                .background(
                    color = props.questColor?.color ?: QuestTypeColors.DEFAULT.color,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Column(
            modifier = Modifier.padding(4.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Row() {
                Icon(
                    modifier = Modifier.size(24.dp).padding(end = 6.dp),
                    painter = painterResource(id = props.questIcon.icon),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier,
                    text = shortenQuestTitle(props.questTitle),
                    color = Color.Black,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.padding(4.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Spacer(modifier = Modifier.padding(end = 24.dp))
                when (props) {
                    is DefaultQuest -> DefaultQuestComponent(props = props)
                    is RepeatingQuest -> RepeatingQuestComponent(props = props)
                    is WeekdayQuest -> {
                        WeekdayQuestComponent(props = props)
                    }
                }
            }
        }
    }
}

fun shortenQuestTitle(questTitle: String): String {
    val maximumCharacters = 80
    return if (questTitle.length > maximumCharacters) {
        questTitle.substring(0, maximumCharacters) + " ..."
    } else questTitle
}
