package gw.gobpo2005.rawg.common.data

import java.net.UnknownHostException

sealed class Failure {

    abstract val message: String

    companion object {
        fun handleException(exception: Exception): Failure {
            return when (exception) {
                is UnknownHostException -> NoInternetConnectionError
                else -> DefaultException
            }
        }
    }

    object NoInternetConnectionError : Failure() {
        override val message: String
            get() = "No internet, check your connection"
    }

    object DefaultException : Failure() {
        override val message: String
            get() = "some error happened!"

    }
}