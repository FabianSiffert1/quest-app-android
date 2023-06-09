package de.siffertio.app.quest.backendPlaceholder

import de.siffertio.app.quest.components.questComponents.model.Quest

class PlaceholderQuestDatabaseImpl() : PlaceholderQuestDatabase {
    override val database = mutableListOf<Quest>()
}
