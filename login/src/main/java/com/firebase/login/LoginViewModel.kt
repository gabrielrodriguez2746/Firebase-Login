package com.firebase.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(
    private val repository: LoginRepository
) : ViewModel() {

    private val _data: MutableLiveData<User> = MutableLiveData()
    val data get() = _data

    fun onLogin() {
        viewModelScope.launch {
            val user = withContext(Dispatchers.Default) {
                repository.login()
            }
            _data.postValue(user)
        }
    }

}