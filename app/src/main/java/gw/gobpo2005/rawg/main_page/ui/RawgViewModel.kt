package gw.gobpo2005.rawg.main_page.ui

import gw.gobpo2005.rawg.common.mvvm.BaseMvvm
import gw.gobpo2005.rawg.main_page.interactor.Interactor
import gw.gobpo2005.rawg.main_page.model.GamesData
import gw.gobpo2005.rawg.main_page.ui.model.ResultDataUi
import gw.gobpo2005.rawg.utils.Constants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import timber.log.Timber

class RawgViewModel(
    private val interactor: Interactor,
) : BaseMvvm() {

    private val _gamesData = MutableStateFlow<List<ResultDataUi?>>(emptyList())
    val gamesData = _gamesData.asStateFlow()


    fun getGamesData() {
        handle {
            val data = interactor.getGamesData(Constants.API_KEY)
            _gamesData.emit()
            Timber.i("___viewModel -> $data")
        }
    }
}