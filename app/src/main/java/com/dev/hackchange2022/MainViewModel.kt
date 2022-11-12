package com.dev.hackchange2022

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.hackchange2022.data.Message
import com.dev.hackchange2022.data.UserAuth
import com.dev.hackchange2022.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {
    private val _allMsg = MutableLiveData<List<Message>>()
    val allMsg: LiveData<List<Message>>
        get() = _allMsg

    private val _Usera = MutableLiveData<UserAuth>()
    val Usera: LiveData<UserAuth>
        get() = _Usera

    fun Auth(login: String, password: String) {
        viewModelScope.launch {
            repository.Auth(login, password).let {
                _Usera.postValue(it.body())
                if (it.isSuccessful) {
                    _Usera.postValue(it.body())
                } else {
                    Log.d("Error", "Failed, check data ${it.errorBody()}")
                }
            }
        }
    }

    fun getHistory() {
        viewModelScope.launch {
            repository.HistoryMsg().let {
                if (it.isSuccessful) {
                    _allMsg.postValue(it.body())
                } else {
                    Log.d("Error", "Failed, check data ${it.errorBody()}")
                }
            }
        }




    }

}