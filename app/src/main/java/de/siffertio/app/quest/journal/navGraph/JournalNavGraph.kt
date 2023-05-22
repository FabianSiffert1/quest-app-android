import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph
@NavGraph(route = "JournalNavGraph")
annotation class JournalNavGraph(val start: Boolean = false)
