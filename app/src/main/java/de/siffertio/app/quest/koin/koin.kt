package de.siffertio.app.quest.koin

import de.siffertio.app.quest.backendPlaceholder.PlaceholderQuestDatabase
import de.siffertio.app.quest.components.questComponents.repositories.QuestRepository
import de.siffertio.app.quest.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::HomeViewModel)
    singleOf(::QuestRepository)
    single { get<PlaceholderQuestDatabase>() }
}
