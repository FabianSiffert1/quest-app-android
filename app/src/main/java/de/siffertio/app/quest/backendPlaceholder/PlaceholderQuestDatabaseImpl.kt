package de.siffertio.app.quest.backendPlaceholder

import de.siffertio.app.quest.components.questComponents.model.QuestTypes

class PlaceholderQuestDatabaseImpl() : PlaceholderQuestDatabase {
    override val quests = mutableListOf<QuestTypes>()
}
