package de.siffertio.app.quest.components.questComponents.model

import QuestTypeColors
import de.siffertio.app.quest.components.questComponents.ui.QuestIcons

enum class QuestTypes(val color: QuestTypeColors, val Icon: QuestIcons) {
    DEFAULT(QuestTypeColors.DEFAULT, QuestIcons.DEFAULT),
    REPEATING(QuestTypeColors.REPEATING, QuestIcons.REPEATING)
}
