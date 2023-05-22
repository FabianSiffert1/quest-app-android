package de.siffertio.app.quest.components.questComponents.ui

import androidx.annotation.DrawableRes
import de.siffertio.app.quest.R

enum class QuestIcons(@DrawableRes val icon: Int) {
    COOKING(R.drawable.icon_kitchen_cooker_utensils),
    CREATIVE(R.drawable.icon_brush_pencil),
    DEFAULT(R.drawable.ic_checkmark_box),
    GARDENING(R.drawable.icon_flower_plant),
    MEAT(R.drawable.icon_meat_food),
    MEDITATION(R.drawable.icon_meditation_yoga),
    REPEATING(R.drawable.ic_repeating_quest),
    RUNNING(R.drawable.icon_sports_shoe),
    STRENGTH_TRAINING(R.drawable.icon_dumbbell),
}
