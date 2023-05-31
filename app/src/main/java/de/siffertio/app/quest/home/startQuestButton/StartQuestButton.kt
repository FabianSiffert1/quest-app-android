package de.siffertio.app.quest.home.startQuestButton

import CoolColors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import de.siffertio.app.quest.R

@Composable
fun StartQuestButton() {
    Box(
        modifier =
            Modifier.clip(shape = RoundedCornerShape(24.dp))
                .background(color = CoolColors.PURPLE.color)
    ) {
        Icon(
            modifier = Modifier.size(50.dp).padding(8.dp),
            painter = painterResource(id = R.drawable.ic_crossed_swords),
            contentDescription = "Begin new quest!",
        )
    }
}
