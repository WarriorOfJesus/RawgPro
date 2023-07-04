package gw.gobpo2005.rawg.main_page.ui

import androidx.lifecycle.viewModelScope
import gw.gobpo2005.rawg.common.mvvm.BaseMvvm
import gw.gobpo2005.rawg.main_page.interactor.MainPageInteractor
import gw.gobpo2005.rawg.main_page.ui.model.ResultDataUi
import gw.gobpo2005.rawg.utils.Constants
import kotlinx.coroutines.flow.*
import timber.log.Timber

class RawgViewModel(
    private val interactor: MainPageInteractor,
) : BaseMvvm() {

    val gamesData = flow {
        emitAll(interactor.getGamesFromDb())
    }
        .catch {

        }// обработать любые ошибки
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    fun getGamesData() {
        handle {
            interactor.loadGames()
            Timber.i("___viewModel -> ")
        }
    }
}