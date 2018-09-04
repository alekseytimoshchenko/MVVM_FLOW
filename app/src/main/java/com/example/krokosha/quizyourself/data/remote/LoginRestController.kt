package com.example.krokosha.quizyourself.data.remote

import com.example.krokosha.quizyourself.data.model.User

class LoginRestController
{
    fun getUser(loginRequest: LoginRequest): LoginResponse
    {
        //To simulate downloading
        return LoginResponse(User("Joe"), false)
    }
}

class LoginResponse(val user: User, val isConnectionError: Boolean = false)

class LoginRequest(val username: String, val password: String)