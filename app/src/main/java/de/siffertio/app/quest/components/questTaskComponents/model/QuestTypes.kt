package de.siffertio.app.quest.components.questTaskComponents.model

import androidx.compose.ui.graphics.Color

enum class QuestTypeColors(val color: Color) {
    DEFAULT(Color(0xFFBED6FA)),
    REPEATING(Color(0xFF74FDD5)),
    SHARED(Color(0xFFF9F871)),
    DEACTIVATED(Color(0xFFA1ACBD)),
    FAILED(Color(0xFFEC9C94))
}

enum class QuestTypes(val color: QuestTypeColors) {
    DEFAULT(QuestTypeColors.DEFAULT),
    REPEATING(QuestTypeColors.REPEATING),
    SHARED(QuestTypeColors.SHARED)
}
