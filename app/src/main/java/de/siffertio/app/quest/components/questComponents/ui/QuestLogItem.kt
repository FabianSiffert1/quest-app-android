package de.siffertio.app.quest.components.questComponents.ui

import androidx.annotation.DrawableRes
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
import de.siffertio.app.quest.components.questComponents.model.DefaultQuest
import de.siffertio.app.quest.components.questComponents.model.Quest
import de.siffertio.app.quest.components.questComponents.model.RepeatingQuest
import de.siffertio.app.quest.components.questComponents.model.WeekdayQuest
import de.siffertio.app.quest.components.questComponents.ui.questLogItemComponents.DefaultQuestComponent
import de.siffertio.app.quest.components.questComponents.ui.questLogItemComponents.QuestTypeColors
import de.siffertio.app.quest.components.questComponents.ui.questLogItemComponents.RepeatingQuestComponent
import de.siffertio.app.quest.components.questComponents.ui.questLogItemComponents.WeekdayQuestComponent

@Composable
fun QuestLogItem(props: Quest) {

    val shortenedQuestTitle = shortenQuestTitle(props.title)

    Box(modifier = Modifier.fillMaxWidth(2f)) {
        Row(
            modifier =
                Modifier.fillMaxWidth(1f)
                    .background(
                        color = props.color?.color ?: QuestTypeColors.DEFAULT.color,
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
        QuestTypeIcon(icon = props.icon.icon)
    }
}

fun shortenQuestTitle(questTitle: String): String {
    val maximumCharacters = 80
    return if (questTitle.length > maximumCharacters) {
        questTitle.substring(0, maximumCharacters) + " ..."
    } else questTitle
}

@Composable
fun QuestTypeIcon(@DrawableRes icon: Int) {
    Box(
        modifier =
            Modifier.size(40.dp)
                .offset(x = 300.dp, y = -(25).dp)
                .clip(shape = RoundedCornerShape(32.dp))
                .background(color = MaterialTheme.colorScheme.surface),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(30.dp).padding(6.dp),
            painter = painterResource(id = icon),
            contentDescription = null,
        )
    }
}
