package de.siffertio.app.quest.backendPlaceholder

import de.siffertio.app.quest.components.questComponents.model.Quest

interface PlaceholderQuestDatabase {
    val database: MutableList<Quest>
}
