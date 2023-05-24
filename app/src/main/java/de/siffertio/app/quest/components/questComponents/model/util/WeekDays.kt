package de.siffertio.app.quest.components.questComponents.model.util

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import de.siffertio.app.quest.R
import java.util.Calendar

enum class WeekDays(@DrawableRes val icon: Int, @StringRes val text: Int) {
    MONDAY(icon = R.drawable.ic_monday, text = R.string.monday),
    TUESDAY(icon = R.drawable.ic_tuesday, text = R.string.tuesday),
    WEDNESDAY(icon = R.drawable.ic_wednesday, text = R.string.wednesday),
    THURSDAY(icon = R.drawable.ic_thursday, text = R.string.thursday),
    FRIDAY(icon = R.drawable.ic_friday, text = R.string.friday),
    SATURDAY(icon = R.drawable.ic_saturday, text = R.string.saturday),
    SUNDAY(icon = R.drawable.ic_sunday, text = R.string.sunday)
}

fun getCurrentWeekDay(): WeekDays {
    val calendar = Calendar.getInstance()

    return when (calendar.get(Calendar.DAY_OF_WEEK)) {
        Calendar.MONDAY -> WeekDays.MONDAY
        Calendar.TUESDAY -> WeekDays.TUESDAY
        Calendar.WEDNESDAY -> WeekDays.WEDNESDAY
        Calendar.THURSDAY -> WeekDays.THURSDAY
        Calendar.FRIDAY -> WeekDays.FRIDAY
        Calendar.SATURDAY -> WeekDays.SATURDAY
        Calendar.SUNDAY -> WeekDays.SUNDAY
        else -> {
            return WeekDays.SUNDAY
        }
    }
}
