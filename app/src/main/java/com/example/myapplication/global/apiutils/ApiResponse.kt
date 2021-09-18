package com.example.myapplication.global.apiutils

import com.example.myapplication.R
import com.example.myapplication.global.AppApplication
import java.net.SocketTimeoutException
/**
 * Author : Deepak Sharma(Webaddicted)
 * Email : techtamper@gmail.com
 * Profile : https://github.com/webaddicted
 */
class ApiResponse<T>(val status: Status, val data: T?, error: Throwable?) {

     var errorMessage: String? = null
    private var errorType: Error? = null

    init {
        if (error == null && status == Status.ERROR) {
            errorType = Error.API_ERROR
        } else if (error is SocketTimeoutException) {
            errorType = Error.TIMEOUT_ERROR
            errorMessage = AppApplication.res.getString(R.string.network_error)
        } else {
            errorType = Error.SERVER_ERROR
            errorMessage = AppApplication.res.getString(R.string.internal_server_error)
        }
    }

    companion object {
        fun <T> loading(): ApiResponse<T> {
            return ApiResponse(
                Status.LOADING,
                null,
                null
            )
        }

        fun <T> success(data: T): ApiResponse<T> {
            return ApiResponse(
                Status.SUCCESS,
                data,
                null
            )
        }

        fun <T> error(error: Throwable?): ApiResponse<T> {
            return ApiResponse(
                Status.ERROR,
                null,
                error
            )
        }
    }

    enum class Status {
        LOADING,
        SUCCESS,
        ERROR,
    }

    enum class Error {
        SERVER_ERROR,
        TIMEOUT_ERROR,
        API_ERROR

    }
}