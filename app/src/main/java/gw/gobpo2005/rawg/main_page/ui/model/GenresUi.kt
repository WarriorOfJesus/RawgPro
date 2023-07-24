package gw.gobpo2005.rawg.main_page.ui.model

import gw.gobpo2005.rawg.common.data.DataHandler
import gw.gobpo2005.rawg.main_page.model.games.GamesData
import gw.gobpo2005.rawg.main_page.model.games.ShortScreenshot

data class GenresUi(
    val genre: String,
    var page : Int,
    val games: List<DataHandler<GamesData>> = emptyList(),
    val position : Int = -1,
    var isLoadEnabled : Boolean = true,
    val screenshot: List<ShortScreenshot> = emptyList()

)
