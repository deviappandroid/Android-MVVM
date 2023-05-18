package com.iapp.androidmvvm.utils

sealed class ErrorType(open val title: String, open val errorMessage: String) {
    object NoInternet : ErrorType(
        "No Internet",
        "Looks like you don't have an active internet connection"
    )

    object Unknown : ErrorType("Unknown Error", "Oops something went wrong")
}


sealed class Resource<T>(
    open val data: T? = null,
    open val message: String = "Oops something went wrong.",
    open val errorType: ErrorType = ErrorType.Unknown
) {
    data class Success<T>(
        override val data: T? = null,
        override val message: String = "Success."
    ) :
        Resource<T>(data)

    data class Loading<T>(override val data: T? = null) : Resource<T>(data)
    data class Error<T>(
        override val message: String = "Oops something went wrong.",
        override val errorType: ErrorType = ErrorType.Unknown
    ) : Resource<T>(null, message)

}