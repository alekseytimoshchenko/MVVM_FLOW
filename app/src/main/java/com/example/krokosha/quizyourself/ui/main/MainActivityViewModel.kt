package com.example.krokosha.quizyourself.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.krokosha.quizyourself.data.model.User
import com.example.krokosha.quizyourself.data.remote.LoginRequest
import com.example.krokosha.quizyourself.data.remote.LoginResponse
import com.example.krokosha.quizyourself.data.repo.MainActivityRepo
import com.example.krokosha.quizyourself.utils.DataMapper
import com.example.krokosha.quizyourself.utils.LoadingStatus
import com.example.krokosha.quizyourself.utils.Validator

class MainActivityViewModel(private val repo: MainActivityRepo,
                            private val validator: Validator,
                            private val mapper: DataMapper): ViewModel()
{
    private val requestLiveData = MutableLiveData<LoginRequest>()
    
    private val loginResult: LiveData<LoginResponse> = Transformations.map(requestLiveData) {
        repo.requestData(it)
    }
    
    //You need to observe this LiveData to get the User
    val userLiveData: LiveData<User> = Transformations.map(loginResult) {
        if(it.isConnectionError)
        {
            _loadingStatus.value = LoadingStatus.ERROR
        }
        else
        {
            _loadingStatus.value = LoadingStatus.SUCCESS
        }
        
        mapper.convert(it)
    }
    
    private val _loadingStatus: MutableLiveData<LoadingStatus> = MutableLiveData()
    
    //You need to observe this LiveData to get current LoadingStatus
    val loadingStatus: LiveData<LoadingStatus>
        get() = _loadingStatus
    
    fun executeLogin(username: String?, password: String?)
    {
        val loginRequest = LoginRequest(username.orEmpty(), password.orEmpty())
        
        if(validator.isValid(loginRequest))
        {
            _loadingStatus.value = LoadingStatus.LOADING
            requestLiveData.value = loginRequest
        }
        else
        {
            _loadingStatus.value = LoadingStatus.ERROR
        }
    }
}