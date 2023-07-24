package gw.gobpo2005.rawg.main_page.repository

import gw.gobpo2005.rawg.main_page.model.games.GamesData
import gw.gobpo2005.rawg.main_page.model.genres.GenresData

interface MainLocalRepository {

    suspend fun getGamesData(genre: String, page: Int = 1): List<GamesData>

    suspend fun insertGamesToDb(games: List<GamesData>)

    suspend fun getGenres(): List<GenresData>

    suspend fun insertGenresToDb(genres: List<GenresData>)

}
