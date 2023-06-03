package de.siffertio.app.quest.settings

import SettingsNavGraph
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import de.siffertio.app.quest.settings.animations.SettingsScreenTransitions

@Composable
@Destination(style = SettingsScreenTransitions::class)
@SettingsNavGraph(start = true)
fun Settings() {
    // TODO: ViewModel Logic Here
    SettingsScreen()
}

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Settings Screen")
    }
}
