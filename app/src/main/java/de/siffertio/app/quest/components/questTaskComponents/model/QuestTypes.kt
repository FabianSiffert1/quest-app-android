package de.siffertio.app.quest.components.questTaskComponents.model

import androidx.compose.ui.graphics.Color

var defaultQuestColor: Color = Color(0xFFBED6FA)
var repeatingQuestColor: Color = Color(0xFF74FDD5)
var sharedQuestColor: Color = Color(0xFFF9F871)

enum class QuestTypes(val color: Color) {
  DEFAULT(defaultQuestColor),
  REPEATING(repeatingQuestColor),
  SHARED(sharedQuestColor)
}
