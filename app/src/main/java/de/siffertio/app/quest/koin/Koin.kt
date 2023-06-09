package de.siffertio.app.quest.koin

import de.siffertio.app.quest.components.questComponents.repositories.QuestRepository
import de.siffertio.app.quest.components.questComponents.repositories.QuestRepositoryImpl
import de.siffertio.app.quest.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<QuestRepository> { QuestRepositoryImpl() }
    viewModel { HomeViewModel(get()) }
}
