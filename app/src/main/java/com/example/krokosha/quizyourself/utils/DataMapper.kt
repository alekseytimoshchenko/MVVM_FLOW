package com.example.krokosha.quizyourself.utils

import com.example.krokosha.quizyourself.data.model.User
import com.example.krokosha.quizyourself.data.remote.LoginResponse

class DataMapper
{
    // It is just a sample in real app here you have to provide all converting logic
    fun convert(loginResponse: LoginResponse): User = loginResponse.user
}