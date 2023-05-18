package de.siffertio.app.quest.components.questTaskComponents.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.siffertio.app.quest.components.questTaskComponents.model.QuestLogItemClass

@Composable
fun QuestLogItem(props: QuestLogItemClass) {
    val maximumCharacters = 90
    val cutOffString =
        if (props.questTitle.length > maximumCharacters) {
            props.questTitle.substring(0, maximumCharacters) + " ..."
        } else props.questTitle

    Surface(
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        color = (props.questCustomColor ?: props.questType.color.color),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        shape = RoundedCornerShape(8.dp),
        tonalElevation = 8.dp
    ) {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(props.questIcon, contentDescription = props.questTitle)
            Text(text = cutOffString, modifier = Modifier.padding(8.dp))
        }
    }
}
