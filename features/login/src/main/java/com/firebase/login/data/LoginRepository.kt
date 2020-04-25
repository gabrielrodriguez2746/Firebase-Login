package com.firebase.login.data

import com.firebase.login.models.Email
import com.firebase.login.models.Id
import com.firebase.login.models.User
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import timber.log.Timber
import java.io.IOException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class LoginRepository(private val client: GoogleSignInClient) {

    suspend fun login(): User = suspendCoroutine { continuation ->
        client.silentSignIn().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Timber.i("login task successful, result ${task.result}")
                val result: GoogleSignInAccount? = task.result
                continuation.resume(result.map())
            } else {
                Timber.e(task.exception)
                continuation.resumeWithException(task.exception.toLoggingError())
            }
        }
    }

}

private fun GoogleSignInAccount?.map(): User {
    return this?.let { account ->
        User(Email(account.email.orEmpty()), Id(account.id.orEmpty()))
    } ?: throw IOException()
}
