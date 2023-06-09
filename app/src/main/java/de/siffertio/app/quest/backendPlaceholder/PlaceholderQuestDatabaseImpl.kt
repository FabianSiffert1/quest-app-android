package de.siffertio.app.quest.backendPlaceholder

import de.siffertio.app.quest.components.questComponents.model.QuestTypes

class PlaceholderQuestDatabaseImpl(override val quests: PlaceholderQuestDatabaseImpl) :
    PlaceholderQuestDatabase {
    var questList: MutableList<QuestTypes> = mutableListOf<QuestTypes>()

    fun addQuestList(newQuestsList: List<QuestTypes>) {
        val currentQuestsList: MutableList<QuestTypes> = ArrayList()
        currentQuestsList.addAll(this.questList)
        currentQuestsList.addAll(newQuestsList)
        this.questList = currentQuestsList
    }

    fun addQuest(quest: QuestTypes) {
        val helperQuestList: List<QuestTypes> = listOf(quest)
        val currentQuestsList: MutableList<QuestTypes> = ArrayList()
        currentQuestsList.addAll(this.questList)
        currentQuestsList.addAll(helperQuestList)
        this.questList = currentQuestsList
    }
}
