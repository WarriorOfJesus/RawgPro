package gw.gobpo2005.rawg.main_page.interactor

import gw.gobpo2005.rawg.main_page.model.games.GamesData
import gw.gobpo2005.rawg.main_page.model.genres.GenresData
import gw.gobpo2005.rawg.main_page.repository.MainLocalRepository
import gw.gobpo2005.rawg.main_page.repository.remote.MainRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class MainPageInteractor(
    private val remoteRepository: MainRemoteRepository,
    private val localRepository: MainLocalRepository,
) {

    suspend fun getGames(page: Int, genre: String): List<GamesData> {
        return withContext(Dispatchers.IO) {
            val localGamesData = localRepository.getGamesData(genre, page)
            localGamesData.ifEmpty {
                val remoteGamesData = remoteRepository.getGamesData(page, genre)
                localRepository.insertGamesToDb(remoteGamesData)
                remoteGamesData
            }
        }
    }


    suspend fun getGenres(): List<GenresData> {
        return withContext(Dispatchers.IO) {
            val localGenresData = localRepository.getGenres()
            localGenresData.ifEmpty {
                val remoteGenresData = remoteRepository.getGenresGames()
                localRepository.insertGenresToDb(remoteGenresData)
                remoteGenresData
            }
        }
    }
}
