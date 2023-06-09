package de.siffertio.app.quest.components.questComponents.repositories

import de.siffertio.app.quest.backendPlaceholder.PlaceholderQuestDatabase
import de.siffertio.app.quest.components.questComponents.model.Quest

interface QuestRepository {
    fun addQuestList(newQuestsList: List<Quest>)
    fun addQuest(quest: Quest)

    fun getQuests(): List<Quest>
}

class QuestRepositoryImpl(private val _questDatabase: PlaceholderQuestDatabase) : QuestRepository {

    private val questDatabase = _questDatabase

    override fun addQuestList(newQuestsList: List<Quest>) {
        questDatabase.database.addAll(newQuestsList)
    }
    override fun addQuest(quest: Quest) {
        questDatabase.database.add(quest)
    }

    override fun getQuests(): List<Quest> {
        return questDatabase.database
    }
}
