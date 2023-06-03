package de.siffertio.app.quest.backendPlaceholder

import de.siffertio.app.quest.components.quests.model.QuestTypes

class TempQuestDatabase {
    var questList: MutableList<QuestTypes> = mutableListOf<QuestTypes>()

    fun appendListElements(elements: List<QuestTypes>) {
        val list: MutableList<QuestTypes> = ArrayList()
        list.addAll(questList)
        list.addAll(elements)
        questList = list
    }
}
