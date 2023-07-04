package gw.gobpo2005.rawg.main_page.repository

import gw.gobpo2005.rawg.main_page.db.dao.GamesDao
import gw.gobpo2005.rawg.main_page.db.model.DataBaseConverter
import gw.gobpo2005.rawg.main_page.model.ResultData
import gw.gobpo2005.rawg.main_page.ui.model.ResultDataUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GamesLocalRepositoryImpl(
    private val gamesDao: GamesDao
) : GamesLocalRepository {
    override suspend fun getGamesData(): Flow<List<ResultDataUi>> {
        val games = gamesDao.getAllGames()
        return games.map { DataBaseConverter.fromDataBase(it) }
    }

    override suspend fun insertGamesToDb(games: List<ResultData>) {
        val gamesEntity = DataBaseConverter.toDataBase(games)
        gamesDao.insertAll(gamesEntity)
    }


}