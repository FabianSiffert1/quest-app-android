import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@NavGraph(route = "HomeNavGraph")
annotation class HomeNavGraph(val start: Boolean = false)
