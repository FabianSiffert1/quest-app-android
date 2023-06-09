package de.siffertio.app.quest.components.questComponents.ui.questLogItemComponents

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import de.siffertio.app.quest.components.questComponents.model.DefaultQuest

@Composable
fun DefaultQuestComponent(props: DefaultQuest) {
    Text(
        text = "Task%CompletedPlaceholder",
        fontSize = 14.sp,
        fontStyle = FontStyle.Italic,
        color = Color.Black
    )
}
