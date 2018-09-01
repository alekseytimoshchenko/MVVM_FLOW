package com.example.krokosha.quizyourself.utils

import com.example.krokosha.quizyourself.data.remote.LoginRequest

class Validator
{
    // It is just a simple sample in real app you need to provide here all requested
    // validating logic
    fun isValid(loginRequest: LoginRequest): Boolean
            = loginRequest.username.isNotEmpty() && loginRequest.password.isNotEmpty()
}