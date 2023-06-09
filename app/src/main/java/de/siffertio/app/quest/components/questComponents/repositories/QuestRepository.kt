package de.siffertio.app.quest.components.questComponents.repositories

import de.siffertio.app.quest.backendPlaceholder.PlaceholderQuestDatabase
import de.siffertio.app.quest.backendPlaceholder.PlaceholderQuestDatabaseImpl

interface QuestRepository {
    val questList: PlaceholderQuestDatabase
}

class QuestRepositoryImpl : QuestRepository {
    private val questDatabase: PlaceholderQuestDatabase()

}
