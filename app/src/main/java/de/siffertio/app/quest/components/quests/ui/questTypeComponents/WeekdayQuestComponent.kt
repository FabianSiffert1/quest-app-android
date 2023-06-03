package de.siffertio.app.quest.components.quests.ui.questTypeComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import de.siffertio.app.quest.components.quests.model.WeekdayQuest

@Composable
fun WeekdayQuestComponent(props: WeekdayQuest) {
    val weekdaysInQuest = props.questDays

    weekdaysInQuest.forEach { day ->
        Row(
            modifier =
                Modifier.size(32.dp)
                    .clip(shape = RoundedCornerShape(32.dp))
                    .background(color = MaterialTheme.colorScheme.surface),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = day.icon),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.padding(end = 8.dp))
    }
}
