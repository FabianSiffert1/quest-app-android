package de.siffertio.app.quest.components.questComponents.ui.questTypeComponents

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import de.siffertio.app.quest.components.questComponents.model.WeekdayQuest

@Composable
fun WeekdayQuestComponent(props: WeekdayQuest) {
    val weekdaysInQuest = props.questDays

    weekdaysInQuest.forEach { day ->
        Icon(
            modifier = Modifier.size(30.dp).padding(end = 6.dp),
            painter = painterResource(id = day.icon),
            contentDescription = null
        )
    }
}
