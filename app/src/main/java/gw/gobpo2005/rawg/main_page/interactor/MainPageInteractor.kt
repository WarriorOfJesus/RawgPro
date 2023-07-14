package gw.gobpo2005.rawg.main_page.interactor

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import gw.gobpo2005.rawg.main_page.db.dao.GamesDao
import gw.gobpo2005.rawg.main_page.db.model.GamesEntity
import gw.gobpo2005.rawg.main_page.model.games.GamesData
import gw.gobpo2005.rawg.main_page.model.genres.GenresData
import gw.gobpo2005.rawg.main_page.paging.MainPageRemoteMediator
import gw.gobpo2005.rawg.main_page.repository.GamesLocalRepository
import gw.gobpo2005.rawg.main_page.repository.remote.GamesRemoteRepository
import gw.gobpo2005.rawg.main_page.repository.remote.GamesRemoteRepositoryImpl
import gw.gobpo2005.rawg.main_page.repository.remote.GenresRepository
import gw.gobpo2005.rawg.main_page.repository.remote.GenresRepositoryImpl
import gw.gobpo2005.rawg.main_page.ui.model.ResultDataUi
import gw.gobpo2005.rawg.utils.Constants
import kotlinx.coroutines.flow.Flow
import timber.log.Timber

class MainPageInteractor(
    private val remoteRepository: GamesRemoteRepository,
    private val localRepository: GamesLocalRepository,
    private val genresRepository: GenresRepository,
) {

    @OptIn(ExperimentalPagingApi::class)
    suspend fun getGamesFromDb(genre: String): Flow<PagingData<GamesEntity>> {
        Timber.i("___getGamesFromDb")
        return Pager(
            config = PagingConfig(
                pageSize = Constants.NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            remoteMediator = MainPageRemoteMediator(
                onLoadGames = {
                    remoteRepository.getGamesData(it, genre = genre)
                },
                onSaveGames = {games ->
                    localRepository.insertGamesToDb(games)
                }
            ),
            pagingSourceFactory = {
                localRepository.getGamesData(genre)
            },
            initialKey = 1
        ).flow
    }

//    suspend fun loadGames() {
//        Timber.i("___LoadGames")
//        val games = remoteRepository.getGamesData(0).result
//        Timber.d("___load -> $games")
//        localRepositoryImpl.insertGamesToDb(games = games)
//    }

    suspend fun getGenresData(): List<GenresData> {
        return genresRepository.getGenresGames()
    }

}