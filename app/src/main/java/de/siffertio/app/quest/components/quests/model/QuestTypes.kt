package de.siffertio.app.quest.components.quests.model

import QuestTypeColors
import android.icu.util.TimeUnit
import de.siffertio.app.quest.components.quests.model.util.WeekDays
import de.siffertio.app.quest.components.quests.ui.QuestIcons
import java.time.LocalDate
import kotlin.time.Duration
import kotlin.time.Duration.Companion.days

sealed interface QuestTypes {
    var dueDate: LocalDate?
    var completed: Boolean?
    var lastCompleted: List<LocalDate>?
    var questTitle: String
    var questIcon: QuestIcons
    var questColor: QuestTypeColors?
}

data class DefaultQuest(
    override var dueDate: LocalDate? = null,
    override var completed: Boolean? = null,
    override var lastCompleted: List<LocalDate>? = null,
    override var questTitle: String = "Default Quest",
    override var questIcon: QuestIcons = QuestIcons.DEFAULT,
    override var questColor: QuestTypeColors? = QuestTypeColors.DEFAULT
) : QuestTypes

data class RepeatingQuest(
    override var dueDate: LocalDate? = null,
    override var completed: Boolean? = null,
    override var lastCompleted: List<LocalDate>? = null,
    override var questTitle: String = "Repeating Quest",
    override var questIcon: QuestIcons = QuestIcons.REPEATING,
    override var questColor: QuestTypeColors? = QuestTypeColors.REPEATING,
    var repetitionInterval: Duration = 1.days
) : QuestTypes {
    private fun scheduleNextExecution(interval: Long, timeUnit: TimeUnit) {
        // Calculate the next execution time based on the repetition interval
        val nextExecutionTime = System.currentTimeMillis() + interval

        println(nextExecutionTime)

        // Schedule the task for the next execution time
        // ...
    }
}

data class WeekdayQuest(
    override var dueDate: LocalDate? = null,
    override var completed: Boolean? = null,
    override var lastCompleted: List<LocalDate>? = null,
    override var questTitle: String = "Weekday Quest",
    override var questIcon: QuestIcons = QuestIcons.WEEKDAY,
    override var questColor: QuestTypeColors? = QuestTypeColors.WEEKDAY,
    var questDays: List<WeekDays> = listOf(WeekDays.MONDAY)
) : QuestTypes {}
