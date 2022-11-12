package com.dev.hackchange2022.data

data class UserAuth(
    val userId: Int,
    val login: String = "",
    val role: String = "",
    val jwtToken: String = "",
)
