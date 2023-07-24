package gw.gobpo2005.rawg.main_page.repository.remote

import gw.gobpo2005.rawg.main_page.api.RawgApi
import gw.gobpo2005.rawg.main_page.model.converter.MainPageGamesConverter
import gw.gobpo2005.rawg.main_page.model.converter.MainPageGenresConverter
import gw.gobpo2005.rawg.main_page.model.games.GamesData
import gw.gobpo2005.rawg.main_page.model.genres.GenresData

class GamesRemoteRepositoryImpl(
    private val api: RawgApi
) : MainRemoteRepository {
    override suspend fun getGamesData( page: Int, genre : String): List<GamesData> {
        val data = api.getListOfGame(page, genres = genre)
        return MainPageGamesConverter.fromNetworkListGames(data.results, genre)
    }

    override suspend fun getGenresGames(): List<GenresData>  {
        val data = api.getListOfGenres()
        return MainPageGenresConverter.fromNetworkResultGenres(data.results)
    }

}