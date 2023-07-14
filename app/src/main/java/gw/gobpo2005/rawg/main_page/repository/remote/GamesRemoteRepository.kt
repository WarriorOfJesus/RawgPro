package gw.gobpo2005.rawg.main_page.repository.remote

import gw.gobpo2005.rawg.main_page.model.games.GamesFullData

interface GamesRemoteRepository {
    suspend fun getGamesData(page: Int, genre: String): GamesFullData
}