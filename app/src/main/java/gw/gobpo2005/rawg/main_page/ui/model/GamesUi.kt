package gw.gobpo2005.rawg.main_page.ui.model

import androidx.paging.PagingData
import gw.gobpo2005.rawg.main_page.db.model.GamesEntity

data class GamesUi(
    val genre: String,
    val games: PagingData<GamesEntity>,
    var isLoadEnabled : Boolean = true
)
