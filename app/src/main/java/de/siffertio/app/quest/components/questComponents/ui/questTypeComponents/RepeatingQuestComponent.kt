package de.siffertio.app.quest.components.questComponents.ui.questTypeComponents

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.siffertio.app.quest.components.questComponents.model.RepeatingQuest

@Composable
fun RepeatingQuestComponent(props: RepeatingQuest) {
    Icon(
        modifier = Modifier.size(24.dp).padding(end = 6.dp),
        painter = painterResource(id = props.questIcon.icon),
        contentDescription = null
    )
    Text(
        text = "Every ${props.repetitionInterval.inWholeDays.toString()} day/s",
        fontSize = 14.sp,
        fontStyle = FontStyle.Italic
    )
}
