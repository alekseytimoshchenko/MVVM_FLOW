package com.example.krokosha.quizyourself.data.remote

import com.example.krokosha.quizyourself.data.model.User

class MainRestController
{
    fun getUser(loginRequest: LoginRequest): LoginResponse
    {
        //To simulate downloading
        Thread.sleep(2500)
        return LoginResponse(User(""), false)
    }
}

class LoginResponse(val user: User, val isConnectionError: Boolean = false)

class LoginRequest(val username: String, val password: String)