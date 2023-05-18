package de.siffertio.app.quest.components.questTaskComponents.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class QuestLogItemClass(
    val questTitle: String = "Default Quest Title",
    val questIcon: ImageVector = Icons.Default.Add,
    val questType: QuestTypes = QuestTypes.DEFAULT,
    val questCustomColor: Color? = null,
)
