package gw.gobpo2005.rawg.main_page.repository

import gw.gobpo2005.rawg.main_page.db.dao.GamesDao
import gw.gobpo2005.rawg.main_page.db.dao.GenresDao
import gw.gobpo2005.rawg.main_page.db.model.GamesEntity
import gw.gobpo2005.rawg.main_page.db.model.GenresEntity
import gw.gobpo2005.rawg.main_page.model.games.GamesData
import gw.gobpo2005.rawg.main_page.model.genres.GenresData
import gw.gobpo2005.rawg.utils.Utils.PAGE_SIZE
import timber.log.Timber


class GamesLocalRepositoryImpl(
    private val gamesDao: GamesDao,
    private val genresDao: GenresDao
) : MainLocalRepository {
    override suspend fun getGamesData(genre: String, page: Int): List<GamesData> {
        Timber.d("_#getGamesData : $genre $page")
        return gamesDao.getAllGames(
            genre = genre,
            limit = PAGE_SIZE,
            offset = page * PAGE_SIZE - PAGE_SIZE
        ).map(GamesEntity::toGamesData)
    }

    override suspend fun insertGamesToDb(games: List<GamesData>) {
        Timber.d("_#insertGamesToDB : $games")
        gamesDao.setGames(games = games.map(GamesData::toGamesEntity))
    }

    override suspend fun getGenres(): List<GenresData> {
        return genresDao.getGenres().map(GenresEntity::toGenresData)
    }

    override suspend fun insertGenresToDb(genres: List<GenresData>) {
        genresDao.insert(genres = genres.map(GenresData::toGenres))
    }


}
