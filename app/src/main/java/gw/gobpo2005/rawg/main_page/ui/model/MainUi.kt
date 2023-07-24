package gw.gobpo2005.rawg.main_page.ui.model

import gw.gobpo2005.rawg.main_page.model.games.GamesData
import ru.surfstudio.android.datalistpagecount.domain.datalist.DataList
import ru.surfstudio.android.easyadapter.pagination.PaginationState

sealed class MainUi{

    data class Genre(val name: String) : MainUi()

    data class GamesList(
        val genre: String,
        val games: DataList<GamesData>,
        val paginationState: PaginationState,
        val page: Int,
        val lastVisiblePosition: Int
    ) : MainUi()
}
