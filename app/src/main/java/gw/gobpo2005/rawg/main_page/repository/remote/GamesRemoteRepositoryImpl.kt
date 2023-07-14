package gw.gobpo2005.rawg.main_page.repository.remote

import gw.gobpo2005.rawg.main_page.api.RawgApi
import gw.gobpo2005.rawg.main_page.model.games.GamesFullData
import gw.gobpo2005.rawg.main_page.model.converter.MainPageGamesConverter

class GamesRemoteRepositoryImpl(
    private val api: RawgApi
) : GamesRemoteRepository {
    override suspend fun getGamesData( page: Int, genre : String): GamesFullData {
        val data = api.getListOfGame(page, genres = genre)
        return MainPageGamesConverter.fromNetwork(data)
    }

}