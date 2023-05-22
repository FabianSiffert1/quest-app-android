package de.siffertio.app.quest.components.questComponents.model

import android.icu.util.TimeUnit
import androidx.compose.ui.graphics.Color
import de.siffertio.app.quest.components.questComponents.ui.QuestIcons
import java.time.LocalDate
import kotlin.time.Duration

abstract class QuestBaseClass(
    open val dueDate: LocalDate?,
    open val completed: Boolean?,
    open val lastCompleted: List<LocalDate>?,
    open val questTitle: String,
    open val questIcon: QuestIcons,
    open val questType: QuestTypes,
    open val questCustomColor: Color?,
)

class DefaultQuest() :
    QuestBaseClass(
        dueDate = null,
        completed = null,
        lastCompleted = null,
        questTitle = "Default Quest Title",
        questIcon = QuestTypes.DEFAULT.Icon,
        questCustomColor = null,
        questType = QuestTypes.DEFAULT
    ) {}

class RepeatingQuest(private var repetitionInterval: Duration) :
    QuestBaseClass(
        dueDate = null,
        completed = null,
        lastCompleted = null,
        questTitle = "Repeating Quest Title",
        questIcon = QuestTypes.REPEATING.Icon,
        questCustomColor = null,
        questType = QuestTypes.REPEATING
    ) {
    override val questTitle = "Repeating Quest Title"
    fun setRepetitionInterval(interval: Duration) {
        repetitionInterval = interval
    }
    private fun scheduleNextExecution(interval: Long, timeUnit: TimeUnit) {
        // Calculate the next execution time based on the repetition interval
        val nextExecutionTime = System.currentTimeMillis() + interval

        println(nextExecutionTime)

        // Schedule the task for the next execution time
        // ...
    }
}
