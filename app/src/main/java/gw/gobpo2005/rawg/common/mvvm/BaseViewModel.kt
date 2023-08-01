package gw.gobpo2005.rawg.common.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

open class BaseViewModel : ViewModel() {

    protected val _errors = MutableStateFlow<String?>(null)
    val errors = _errors.asStateFlow()

    protected fun handle(onDataHandler: suspend () -> Unit) {
        viewModelScope.launch {
            try {
                onDataHandler()
            } catch (e: CancellationException) {
                _errors.value = e.message
                Timber.e("___ error --->> ${e.message}")
            } catch (t: Throwable) {
                _errors.value = t.message
                Timber.e("___error --->> ${t.message}")
            }
        }
    }
}
