package de.siffertio.app.quest.journal

import JournalNavGraph
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import de.siffertio.app.quest.journal.animations.JournalScreenTransitions

@Composable
@Destination(style = JournalScreenTransitions::class)
@JournalNavGraph(start = true)
fun Journal() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Journal Screen")
    }
}
