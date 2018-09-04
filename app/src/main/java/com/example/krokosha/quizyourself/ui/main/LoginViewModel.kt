package com.example.krokosha.quizyourself.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krokosha.quizyourself.data.model.User
import com.example.krokosha.quizyourself.data.remote.LoginRequest
import com.example.krokosha.quizyourself.data.repo.Repo
import com.example.krokosha.quizyourself.utils.DataMapper
import com.example.krokosha.quizyourself.utils.LoadingStatus
import com.example.krokosha.quizyourself.utils.Validator
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class LoginViewModel(private val repo: Repo, private val validator: Validator, private val mapper: DataMapper): ViewModel()
{
    private val _loadingStatus: MutableLiveData<LoadingStatus> = MutableLiveData()
    private val _userLiveData: MutableLiveData<User> = MutableLiveData()
    private val _openNextScreen: MutableLiveData<Boolean> = MutableLiveData()
    
    //You need to observe this LiveData to get User from the response
    val userLiveData: LiveData<User>
        get() = _userLiveData
    
    //You need to observe this LiveData to get current LoadingStatus
    val loadingStatus: LiveData<LoadingStatus>
        get() = _loadingStatus
    
    //You need to observe this LiveData to get next screen that has to be opened
    val openNextScreen: LiveData<Boolean>
        get() = _openNextScreen
    
    fun executeLogin(username: String?, password: String?)
    {
        val request = LoginRequest(username.orEmpty(), password.orEmpty())
        
        if(validator.isValid(request))
        {
            Observable.just(LoginRequest(username.orEmpty(), password.orEmpty())) //
                    .doOnNext { } //
                    .doOnNext { _loadingStatus.value = LoadingStatus.LOADING } //
                    .delay(2500, TimeUnit.MILLISECONDS) //
                    .observeOn(Schedulers.io()) //
                    .map { repo.requestData(it) } //
                    .map { mapper.convert(it) } //
                    .doOnNext { _userLiveData.postValue(it) } //
                    .doOnNext { _loadingStatus.postValue(LoadingStatus.SUCCESS) } //
                    .doOnNext { _openNextScreen.postValue(true) } //
                    .subscribe()
        }
        else
        {
            _loadingStatus.value = LoadingStatus.ERROR
        }
    }
}