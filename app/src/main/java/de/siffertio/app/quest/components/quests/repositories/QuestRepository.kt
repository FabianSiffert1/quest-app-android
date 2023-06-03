package de.siffertio.app.quest.components.quests.repositories

import de.siffertio.app.quest.backendPlaceholder.PlaceholderQuestDatabase
import de.siffertio.app.quest.components.quests.model.QuestTypes

class QuestRepository(private val questDatabase: PlaceholderQuestDatabase) {
    // TODO: flowOf
    val _questList: MutableList<QuestTypes>? = questDatabase.quests.questList
}
