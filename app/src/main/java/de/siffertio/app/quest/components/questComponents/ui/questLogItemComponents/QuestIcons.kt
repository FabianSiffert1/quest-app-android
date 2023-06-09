package de.siffertio.app.quest.components.questComponents.ui.questLogItemComponents

import androidx.annotation.DrawableRes
import de.siffertio.app.quest.R

enum class QuestIcons(@DrawableRes val icon: Int) {
    COOKING(R.drawable.ic_kitchen_cooker_utensils),
    CREATIVE(R.drawable.ic_brush_pencil),
    DEFAULT(R.drawable.ic_checkmark_box),
    GARDENING(R.drawable.ic_flower_plant),
    MEAT(R.drawable.ic_meat_food),
    MEDITATION(R.drawable.ic_meditation_yoga),
    REPEATING(R.drawable.ic_repeating_quest),
    RUNNING(R.drawable.ic_sports_shoe),
    STRENGTH_TRAINING(R.drawable.ic_dumbbell),
    WEEKDAY(R.drawable.ic_calendar)
}
