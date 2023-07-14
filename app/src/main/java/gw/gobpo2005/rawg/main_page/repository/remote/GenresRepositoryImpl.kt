package gw.gobpo2005.rawg.main_page.repository.remote

import gw.gobpo2005.rawg.main_page.api.RawgApi
import gw.gobpo2005.rawg.main_page.model.converter.MainPageGenresConverter
import gw.gobpo2005.rawg.main_page.model.genres.GenresData

class GenresRepositoryImpl(
    private val api: RawgApi
) : GenresRepository {
    override suspend fun getGenresGames(): List<GenresData>  {
        val data = api.getListOfGenres()
        return MainPageGenresConverter.fromNetworkResultGenres(data.results)
    }
}