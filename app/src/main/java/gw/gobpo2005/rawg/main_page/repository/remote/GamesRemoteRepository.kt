package gw.gobpo2005.rawg.main_page.repository.remote

import gw.gobpo2005.rawg.main_page.api.RawgApi
import gw.gobpo2005.rawg.main_page.model.GamesData
import gw.gobpo2005.rawg.main_page.model.converter.Converter
import gw.gobpo2005.rawg.utils.Constants

class GamesRemoteRepository(
    private val api: RawgApi
) : GameRepository{
    override suspend fun getGamesData(key: String): GamesData {
        val data = api.getListOfGame(Constants.API_KEY)
        return Converter.fromNetwork(data)
    }
}