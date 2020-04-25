package com.firebase.login.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.firebase.login.data.PollingUserException
import com.firebase.login.data.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class LoginViewModel(private val repository: LoginRepository) : ViewModel() {

    private val _state: MutableLiveData<LoginViewModelState> = MutableLiveData()
    val state get() = _state

    fun login() {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                withContext(Dispatchers.IO) {
                    repository.login()
                }
                _state.postValue(LoginViewModelState.SuccessFullLogin)
            } catch (e: PollingUserException) {
                Timber.e(e)
                _state.postValue(LoginViewModelState.NotLoggedUserError)
            } catch (e: Exception) {
                Timber.e(e)
                _state.postValue(LoginViewModelState.UnexpectedError)
            }
        }
    }

    sealed class LoginViewModelState {
        object UnexpectedError : LoginViewModelState()
        object NotLoggedUserError : LoginViewModelState()
        object SuccessFullLogin : LoginViewModelState()
    }

}