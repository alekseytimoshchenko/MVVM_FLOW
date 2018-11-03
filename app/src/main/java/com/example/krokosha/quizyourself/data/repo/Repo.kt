package com.example.krokosha.quizyourself.data.repo

import com.example.krokosha.quizyourself.data.remote.LoginRequest
import com.example.krokosha.quizyourself.data.remote.LoginResponse
import com.example.krokosha.quizyourself.data.remote.LoginRestController

/**
 * Here you can provide you repository implementation with
 * DB implementation, Share Preferences and REST API.
 * It is depend of your requirements
 *
 * NOTE: that all this actions have to be executed on background thread(up to your decision how)
 * */
class Repo(private val restController: LoginRestController)
{
    
    
    fun requestData(loginRequest: LoginRequest): LoginResponse
    {
        return restController.getUser(loginRequest)
    }
}