package de.siffertio.app.quest.components.questComponents.model

import android.icu.util.TimeUnit
import de.siffertio.app.quest.components.questComponents.model.util.WeekDays
import de.siffertio.app.quest.components.questComponents.ui.questLogItemComponents.QuestIcons
import de.siffertio.app.quest.components.questComponents.ui.questLogItemComponents.QuestTypeColors
import java.time.LocalDate
import kotlin.time.Duration
import kotlin.time.Duration.Companion.days

sealed interface Quest {
    var dueDate: LocalDate?
    var completed: Boolean?
    var lastCompleted: List<LocalDate>?
    var title: String
    var icon: QuestIcons
    var color: QuestTypeColors?
    val questType: QuestType
}

enum class QuestType(val type: String) {
    DEFAULT("Default"),
    REPEATING("Repeating"),
    WEEKDAY("Weekday")
}

data class Task(val id: Int, val description: String, val completed: Boolean)

data class DefaultQuest(
    override val questType: QuestType = QuestType.DEFAULT,
    override var dueDate: LocalDate? = null,
    override var completed: Boolean? = null,
    override var lastCompleted: List<LocalDate>? = null,
    override var title: String = "Default Quest",
    override var icon: QuestIcons = QuestIcons.DEFAULT,
    override var color: QuestTypeColors? = QuestTypeColors.DEFAULT,
    var tasks: List<Task>? = listOf(Task(id = 0, description = "Default Quest", completed = false)),
    var completedTasksCounter: Int = 0,
) : Quest {}

data class RepeatingQuest(
    override val questType: QuestType = QuestType.REPEATING,
    override var dueDate: LocalDate? = null,
    override var completed: Boolean? = null,
    override var lastCompleted: List<LocalDate>? = null,
    override var title: String = "Repeating Quest",
    override var icon: QuestIcons = QuestIcons.REPEATING,
    override var color: QuestTypeColors? = QuestTypeColors.REPEATING,
    var repetitionInterval: Duration = 1.days,
    var successRate: Float = 100f,
) : Quest {
    private fun scheduleNextExecution(interval: Long, timeUnit: TimeUnit) {
        // Calculate the next execution time based on the repetition interval
        val nextExecutionTime = System.currentTimeMillis() + interval

        println(nextExecutionTime)

        // Schedule the task for the next execution time
        // ...
    }
}

data class WeekdayQuest(
    override val questType: QuestType = QuestType.WEEKDAY,
    override var dueDate: LocalDate? = null,
    override var completed: Boolean? = null,
    override var lastCompleted: List<LocalDate>? = null,
    override var title: String = "Weekday Quest",
    override var icon: QuestIcons = QuestIcons.WEEKDAY,
    override var color: QuestTypeColors? = QuestTypeColors.WEEKDAY,
    var questDays: List<WeekDays> = listOf(WeekDays.MONDAY)
) : Quest {}
