package de.siffertio.app.quest.home

import androidx.lifecycle.ViewModel
import de.siffertio.app.quest.components.questComponents.repositories.QuestRepository

class HomeViewModel(private val _questRepository: QuestRepository) : ViewModel() {

    val questRepository = _questRepository
    fun printQuests() {
        questRepository.getQuests().forEach { quest -> println(quest) }
    }
}
