package com.firebase.login.data

import com.google.android.gms.common.api.ApiException
import java.io.IOException
import java.io.InvalidObjectException

class PollingUserException internal constructor(error: ApiException) : InvalidObjectException(error.localizedMessage)

internal fun Exception?.toLoggingError(): Throwable {
    return this?.let {
        when (it) {
            is ApiException -> PollingUserException(it)
            else -> IOException()
        }
    } ?: IOException()
}
