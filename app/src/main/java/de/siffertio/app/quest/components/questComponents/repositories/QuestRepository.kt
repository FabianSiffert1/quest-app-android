package de.siffertio.app.quest.components.questComponents.repositories

import de.siffertio.app.quest.backendPlaceholder.PlaceholderQuestDatabase
import de.siffertio.app.quest.components.questComponents.model.QuestTypes

interface QuestRepository {
    fun addQuestList(newQuestsList: List<QuestTypes>)
    fun addQuest(quest: QuestTypes)

    fun getQuests(): List<QuestTypes>
}

class QuestRepositoryImpl(private val _questDatabase: PlaceholderQuestDatabase) : QuestRepository {

    private val questDatabase = _questDatabase

    override fun addQuestList(newQuestsList: List<QuestTypes>) {
        questDatabase.database.addAll(newQuestsList)
    }
    override fun addQuest(quest: QuestTypes) {
        questDatabase.database.add(quest)
    }

    override fun getQuests(): List<QuestTypes> {
        return questDatabase.database
    }
}
