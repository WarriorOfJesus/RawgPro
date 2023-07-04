package gw.gobpo2005.rawg.main_page.repository

import gw.gobpo2005.rawg.main_page.model.ResultData
import gw.gobpo2005.rawg.main_page.ui.model.ResultDataUi
import kotlinx.coroutines.flow.Flow

interface GamesLocalRepository {

    suspend fun insertGamesToDb(games: List<ResultData>)

    suspend fun getGamesData(): Flow<List<ResultDataUi>>
}