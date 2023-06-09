package de.siffertio.app.quest.components.questComponents.ui.startQuest.startQuestButton

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import de.siffertio.app.quest.R

// TODO: ADD UIState Handler/ Actions
@Composable
fun StartQuestButton(onClick: () -> Unit = {}) {
    Box(
        modifier =
            Modifier.clip(shape = RoundedCornerShape(24.dp))
                .background(color = MaterialTheme.colorScheme.surface)
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(24.dp)
                )
                .clickable { onClick() },
    ) {
        Icon(
            modifier = Modifier.size(50.dp).padding(12.dp),
            painter = painterResource(id = R.drawable.ic_plus_line),
            contentDescription = "Begin new quest!",
        )
    }
}
