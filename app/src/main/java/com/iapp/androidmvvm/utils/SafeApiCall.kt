package com.iapp.androidmvvm.utils

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Response
import java.io.IOException

suspend fun <T, F> safeApiCall(
    successMessage: String = "",
    errorMessage: String? = null,
    call: suspend () -> Response<T>,
    result: suspend (T) -> F?,
): Resource<F> = withContext(Dispatchers.IO) {
    return@withContext try {
        val response = call()
        if (response.isSuccessful) {
            response.body()?.let { data : T ->
                result(data)?.let { Resource.Success(it, successMessage) }
            } ?: Resource.Error(message = errorMessage ?: "DATA NULL")
        } else Resource.Error(
            // git error fixing
            message = errorMessage ?: getMessageFromErrorResponse(response.errorBody())
        )
    } catch (e: IOException) {
        e.toString()
        Resource.Error(errorType = ErrorType.NoInternet, message = errorMessage ?: e.message.toString())
    } catch (e: Exception) {
        e.toString()
        Resource.Error(errorType = ErrorType.Unknown, message = errorMessage ?: e.message.toString())
    }
}

fun getMessageFromErrorResponse(error: ResponseBody?): String {
    return error?.let { Gson().fromJson(it.charStream(), MessageResponse::class.java).message }
        ?: "Unknown Error Occurred"
}

data class MessageResponse(
    @SerializedName("message")
    val message: String = ""
)
