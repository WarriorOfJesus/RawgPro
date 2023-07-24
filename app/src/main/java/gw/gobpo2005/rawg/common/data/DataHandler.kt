package gw.gobpo2005.rawg.common.data

sealed class DataHandler<T>(
    val data: T? = null,
    val failure: Failure? = null
) {
    class Success<T>(data: T) : DataHandler<T>(data)

    class Error<T>(data: T? = null, failure: Failure) : DataHandler<T>(data, failure)

    class Loading<T> : DataHandler<T>()
}
