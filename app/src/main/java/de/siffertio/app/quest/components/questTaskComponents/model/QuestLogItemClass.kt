package de.siffertio.app.quest.components.questTaskComponents.model

import android.icu.util.TimeUnit
import androidx.compose.ui.graphics.Color
import java.time.LocalDate

abstract class QuestLogItemClass(
    val dueDate: LocalDate? = null,
    val completed: Boolean? = null,
    val lastCompleted: List<LocalDate>? = null,
    val questTitle: String = "Default Quest Title",
    val questIcon: QuestIcons = QuestIcons.DEFAULT,
    val questType: QuestTypes = QuestTypes.DEFAULT,
    val questCustomColor: Color? = null,
)

class RepeatingQuest() : QuestLogItemClass() {
    var repetitionInterval: Pair<Long, TimeUnit>? = null
}
