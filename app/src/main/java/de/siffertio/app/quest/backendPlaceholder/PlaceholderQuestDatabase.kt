package de.siffertio.app.quest.backendPlaceholder

import de.siffertio.app.quest.components.questComponents.model.QuestTypes

interface PlaceholderQuestDatabase {
    val quests: MutableList<QuestTypes>
}
