package gw.gobpo2005.rawg.main_page.repository

import android.accessibilityservice.GestureDescription.StrokeDescription
import androidx.paging.PagingSource
import gw.gobpo2005.rawg.main_page.db.model.GamesEntity
import gw.gobpo2005.rawg.main_page.model.games.GamesData
import gw.gobpo2005.rawg.main_page.ui.model.ResultDataUi
import kotlinx.coroutines.flow.Flow

interface GamesLocalRepository {

    fun insertGamesToDb(games: List<GamesData>)

    fun getGamesData(genre : String): PagingSource<Int, GamesEntity>
}