package gw.gobpo2005.rawg.main_page.repository.remote

import gw.gobpo2005.rawg.main_page.model.games.GamesData
import gw.gobpo2005.rawg.main_page.model.genres.GenresData

interface MainRemoteRepository {
    suspend fun getGamesData(page: Int, genre: String): List<GamesData>

    suspend fun getGenresGames() : List<GenresData>
}
