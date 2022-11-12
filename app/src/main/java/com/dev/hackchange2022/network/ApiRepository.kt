package com.dev.hackchange2022.network

import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService ) {
    suspend fun Auth(login:String, password:String) = apiService.Auth(login,password)
    suspend fun HistoryMsg() = apiService.HistoryMsg()
}