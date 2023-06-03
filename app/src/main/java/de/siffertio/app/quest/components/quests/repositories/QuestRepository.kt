package de.siffertio.app.quest.components.quests.repositories

import de.siffertio.app.quest.backendPlaceholder.PlaceholderQuestDatabase

class QuestRepository(private val questDatabase: PlaceholderQuestDatabase) {
    // TODO: flowOf
    val _questList = questDatabase.quests
}
