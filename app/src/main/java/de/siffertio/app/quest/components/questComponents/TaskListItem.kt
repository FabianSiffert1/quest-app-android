package de.siffertio.app.quest.components.questComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TaskListItem(text: String) {
  Surface(
      modifier = Modifier.padding(8.dp),
      color = Color.Transparent,
      border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
      shape = RoundedCornerShape(8.dp),
      tonalElevation = 8.dp) {
        Text(text = text, modifier = Modifier.padding(8.dp))
      }
}
