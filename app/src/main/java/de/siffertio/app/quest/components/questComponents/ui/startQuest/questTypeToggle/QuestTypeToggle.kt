package de.siffertio.app.quest.components.questComponents.ui.startQuest.questTypeToggle

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import de.siffertio.app.quest.components.questComponents.model.QuestType

@OptIn(ExperimentalStdlibApi::class)
@Composable
fun QuestTypeToggle(selectedQuestType: MutableState<QuestType>) {

    val questTypes = QuestType.values()
    val onSelectionChange = { questType: QuestType -> selectedQuestType.value = questType }

    Row(
        modifier =
            Modifier.clip(shape = RoundedCornerShape(24.dp))
                .border(
                    color = MaterialTheme.colorScheme.primary,
                    width = 2.dp,
                    shape = RoundedCornerShape(24.dp)
                ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        questTypes.forEach { questType ->
            var fontWeight = FontWeight.Normal
            if (questType == selectedQuestType.value) {
                fontWeight = FontWeight.Bold
            }
            Text(
                modifier = Modifier.clickable { onSelectionChange(questType) }.padding(12.dp),
                text = questType.type,
                fontWeight = fontWeight
            )
        }
    }
}
