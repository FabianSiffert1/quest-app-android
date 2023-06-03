package de.siffertio.app.quest.components.quests.ui

import QuestTypeColors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.siffertio.app.quest.components.quests.model.DefaultQuest
import de.siffertio.app.quest.components.quests.model.QuestTypes
import de.siffertio.app.quest.components.quests.model.RepeatingQuest
import de.siffertio.app.quest.components.quests.model.WeekdayQuest
import de.siffertio.app.quest.components.quests.ui.questTypeComponents.DefaultQuestComponent
import de.siffertio.app.quest.components.quests.ui.questTypeComponents.RepeatingQuestComponent
import de.siffertio.app.quest.components.quests.ui.questTypeComponents.WeekdayQuestComponent

@Composable
fun Quest(props: QuestTypes) {

    val shortenedQuestTitle = shortenQuestTitle(props.questTitle)

    Box(modifier = Modifier.fillMaxWidth(2f)) {
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
            Column(modifier = Modifier.padding(4.dp)) {
                Text(
                    modifier = Modifier,
                    text = shortenedQuestTitle,
                    color = Color.Black,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.padding(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
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
        Box(
            modifier =
                Modifier.size(32.dp)
                    .offset(x = 300.dp, y = -(20).dp)
                    .clip(shape = RoundedCornerShape(32.dp))
                    .background(color = MaterialTheme.colorScheme.surface),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = props.questIcon.icon),
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

fun shortenQuestTitle(questTitle: String): String {
    val maximumCharacters = 80
    return if (questTitle.length > maximumCharacters) {
        questTitle.substring(0, maximumCharacters) + " ..."
    } else questTitle
}
