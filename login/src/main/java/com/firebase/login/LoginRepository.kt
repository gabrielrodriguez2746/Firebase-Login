package com.firebase.login

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import java.io.InvalidObjectException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class LoginRepository(private val client: GoogleSignInClient) {

    suspend fun login(): User = suspendCoroutine { continuation ->
        client.silentSignIn().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val result: GoogleSignInAccount? = task.result
                continuation.resume(result.map())
            } else {
                continuation.resumeWithException(task.exception.orDefault(InvalidObjectException("Server Error")))
            }
        }
    }

}

private fun GoogleSignInAccount?.map(): User {
    return this?.let { account ->
        User(Email(account.email.orEmpty()), Id(account.id.orEmpty()))
    } ?: throw InvalidObjectException("Nullable user from server")
}

inline class Email(val value: String)
inline class Id(val value: String)
data class User(val email: Email, val id: Id)

fun <T> T?.orDefault(default: T): T {
    return this ?: default
}