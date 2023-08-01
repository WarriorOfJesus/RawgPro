package gw.gobpo2005.rawg.main_page.ui

import androidx.lifecycle.viewModelScope
import gw.gobpo2005.rawg.common.mvvm.BaseViewModel
import gw.gobpo2005.rawg.main_page.interactor.MainPageInteractor
import gw.gobpo2005.rawg.main_page.model.games.GamesData
import gw.gobpo2005.rawg.main_page.model.genres.GenresData
import gw.gobpo2005.rawg.main_page.ui.model.MainUi
import gw.gobpo2005.rawg.utils.Utils.PAGE_SIZE
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.surfstudio.android.datalistpagecount.domain.datalist.DataList
import ru.surfstudio.android.easyadapter.pagination.PaginationState

class RawgViewModel(
    private val interactor: MainPageInteractor,
) : BaseViewModel() {

    private val _mainUi = MutableStateFlow<List<MainUi>>(emptyList())
    val mainUi = _mainUi.asStateFlow()

    init {
        loadGenres()
    }


    private fun loadGenres() {
        handle {
            val genresData = interactor.getGenres()
            _mainUi.value = addGenres(genresData)
        }
    }

    fun loadGames(genre: String, page: Int, position: Int) {
        viewModelScope.launch {
            val lastMainUi = _mainUi.value.map { mainUi ->
                when (mainUi) {
                    is MainUi.GamesList -> {
                        if (mainUi.genre == genre) mainUi.copy(paginationState = PaginationState.READY)
                        else mainUi
                    }
                    is MainUi.Genre -> mainUi
                }
            }
            try {
                val data = interactor.getGames(page, genre)
                _mainUi.value = _mainUi.value.addNewGamesByGenre(data, genre, page, position)
            } catch (e: Exception) {
                _mainUi.value = lastMainUi
                _mainUi.value = _mainUi.value.map { mainUi ->
                    when (mainUi) {
                        is MainUi.GamesList -> {
                            if (mainUi.genre == genre) mainUi.copy(
                                paginationState = PaginationState.ERROR,
                                lastVisiblePosition = mainUi.lastVisiblePosition + PAGE_SIZE + 1
                            )
                            else mainUi
                        }
                        is MainUi.Genre -> mainUi
                    }
                }
            }
        }


    }


    private fun List<MainUi>.addNewGamesByGenre(
        games: List<GamesData>,
        genre: String,
        page: Int,
        position: Int
    ): List<MainUi> =
        map { mainUi ->
            return@map when (mainUi) {
                is MainUi.GamesList -> {
                    if (mainUi.genre != genre) mainUi
                    else mainUi.copy(
                        games = mainUi.games.merge(
                            DataList(games, page, PAGE_SIZE),
                        ),
                        page = page + 1,
                        lastVisiblePosition = page * PAGE_SIZE - PAGE_SIZE,
                        paginationState = PaginationState.READY
                    )
                }
                is MainUi.Genre -> mainUi
            }
        }


    private fun addGenres(genres: List<GenresData>): List<MainUi> {
        val mainUiList: MutableList<MainUi> = mutableListOf()
        genres.forEach {
            mainUiList.add(MainUi.Genre(it.name))

            mainUiList.add(
                MainUi.GamesList(
                    genre = it.slug,
                    games = DataList(emptyList(), 1, PAGE_SIZE),
                    paginationState = PaginationState.READY,
                    page = 1,
                    lastVisiblePosition = 0
                )
            )
        }
        return mainUiList
    }
}
