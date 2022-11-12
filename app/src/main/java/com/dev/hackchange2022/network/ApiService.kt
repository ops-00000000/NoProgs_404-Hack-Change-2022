package com.dev.hackchange2022.network

import com.dev.hackchange2022.data.Message
import com.dev.hackchange2022.data.UserAuth
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("/auth")
    suspend fun Auth(login: String, password: String): Response<UserAuth>

    @GET("chat/history?dialogId=1&limit=1")
    suspend fun HistoryMsg() : Response<List<Message>>

}