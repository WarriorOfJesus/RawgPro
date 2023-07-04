package gw.gobpo2005.rawg.main_page.interactor

import gw.gobpo2005.rawg.utils.Constants
import gw.gobpo2005.rawg.main_page.model.GamesData
import gw.gobpo2005.rawg.main_page.repository.remote.GamesRemoteRepository

class Interactor(
    private val remoteRepository: GamesRemoteRepository,
) {

    suspend fun getGamesData(
        key: String,
    ): GamesData {
        return remoteRepository.getGamesData(Constants.API_KEY)
    }
}