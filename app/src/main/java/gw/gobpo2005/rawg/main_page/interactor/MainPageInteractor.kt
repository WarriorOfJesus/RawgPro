package gw.gobpo2005.rawg.main_page.interactor

import gw.gobpo2005.rawg.main_page.repository.GamesLocalRepository
import gw.gobpo2005.rawg.main_page.repository.remote.GamesRemoteRepositoryImpl
import gw.gobpo2005.rawg.main_page.ui.model.ResultDataUi
import gw.gobpo2005.rawg.utils.Constants
import kotlinx.coroutines.flow.Flow
import timber.log.Timber

class MainPageInteractor(
    private val remoteRepository: GamesRemoteRepositoryImpl,
    private val localRepositoryImpl: GamesLocalRepository,
) {

    suspend fun getGamesFromDb(): Flow<List<ResultDataUi>> {
        Timber.i("___getGamesFromDb")
        return localRepositoryImpl.getGamesData()
    }

    suspend fun loadGames(){
        Timber.i("___LoadGames")
        val games = remoteRepository.getGamesData(Constants.API_KEY).result ?: emptyList()
        Timber.d("___load -> $games")
        localRepositoryImpl.insertGamesToDb(games = games)
    }

}