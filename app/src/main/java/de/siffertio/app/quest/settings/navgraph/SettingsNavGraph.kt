import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph
@NavGraph(route = "SettingsNavGraph")
annotation class SettingsNavGraph(val start: Boolean = false)
