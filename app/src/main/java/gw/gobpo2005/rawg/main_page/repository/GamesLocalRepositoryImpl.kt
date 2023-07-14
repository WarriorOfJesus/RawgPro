package gw.gobpo2005.rawg.main_page.repository

import androidx.paging.PagingSource
import gw.gobpo2005.rawg.main_page.db.dao.GamesDao
import gw.gobpo2005.rawg.main_page.db.model.DataBaseConverter
import gw.gobpo2005.rawg.main_page.db.model.GamesEntity
import gw.gobpo2005.rawg.main_page.model.games.GamesData
import gw.gobpo2005.rawg.main_page.ui.model.ResultDataUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GamesLocalRepositoryImpl(
    private val gamesDao: GamesDao
) : GamesLocalRepository {
    override fun getGamesData(genre: String): PagingSource<Int, GamesEntity> {
        val games = gamesDao.pagingSource()
        return games
    }

    override fun insertGamesToDb(games: List<GamesData>) {
        val gamesEntity = DataBaseConverter.toDataBase(games)
        gamesDao.insertAll(gamesEntity)
    }


}