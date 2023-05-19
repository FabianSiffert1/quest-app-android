package de.siffertio.app.quest.components.questTaskComponents.model

import androidx.compose.ui.graphics.Color

data class QuestLogItemClass(
    val questTitle: String = "Default Quest Title",
    val questIcon: QuestIcons = QuestIcons.DEFAULT,
    val questType: QuestTypes = QuestTypes.DEFAULT,
    val questCustomColor: Color? = null,
)
