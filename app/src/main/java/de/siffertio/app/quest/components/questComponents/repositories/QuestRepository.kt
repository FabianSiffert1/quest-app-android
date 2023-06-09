package de.siffertio.app.quest.components.questComponents.repositories

import de.siffertio.app.quest.components.questComponents.model.DefaultQuest
import de.siffertio.app.quest.components.questComponents.model.QuestTypes

interface QuestRepository {
    fun addQuestList(newQuestsList: List<QuestTypes>)
    fun addQuest(quest: QuestTypes)

    fun getQuests(): List<QuestTypes>
}

class QuestRepositoryImpl() : QuestRepository {
    private val questDatabase = mutableListOf<QuestTypes>()
    init {
        questDatabase.add(DefaultQuest())
    }
    override fun addQuestList(newQuestsList: List<QuestTypes>) {
        questDatabase.plus(newQuestsList)
    }
    override fun addQuest(quest: QuestTypes) {
        questDatabase.add(quest)
    }

    override fun getQuests(): List<QuestTypes> {
        return questDatabase
    }
}
