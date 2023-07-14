package gw.gobpo2005.rawg.main_page.ui

import androidx.paging.PagingData
import androidx.paging.map
import gw.gobpo2005.rawg.common.mvvm.BaseMvvm
import gw.gobpo2005.rawg.main_page.interactor.MainPageInteractor
import gw.gobpo2005.rawg.main_page.repository.remote.GamesRemoteRepository
import gw.gobpo2005.rawg.main_page.ui.model.GamesUi
import gw.gobpo2005.rawg.main_page.ui.model.ParentGenresDataUi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import timber.log.Timber

class RawgViewModel(
    private val interactor: MainPageInteractor,
    private val gamesRepository: GamesRemoteRepository
) : BaseMvvm() {




    private val _gamesData = MutableStateFlow<GamesUi?>(null)
    val gamesData =_gamesData.asStateFlow()


    private val _genresData = MutableStateFlow<List<ParentGenresDataUi>>(emptyList())
    val genresData = _genresData.asStateFlow()



    init {
        getGenres()
    }


    fun getGamesData(genre : String) {
        handle {
//            interactor.loadGames()
           val data = interactor.getGamesFromDb(genre).collect{pagingData ->
               delay(2000)
               _gamesData.value= GamesUi(genre = genre, games = pagingData)
           }
            Timber.i("___viewModel -> ")
        }
    }

    private fun getGenres() {
        handle {
            val data = interactor.getGenresData()
            Timber.d("___$data")
            _genresData.value = data.map {
                ParentGenresDataUi(
                    id = it.id,
                    nameGenres = it.name,
                    image = it.imageBackground,
                    emptyList()
                )
            }
        }
    }



}