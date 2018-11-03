package com.example.krokosha.quizyourself.ui.main

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krokosha.quizyourself.data.model.User
import com.example.krokosha.quizyourself.data.remote.LoginRequest
import com.example.krokosha.quizyourself.data.repo.Repo
import com.example.krokosha.quizyourself.utils.DataMapper
import com.example.krokosha.quizyourself.utils.LoadingStatus
import com.example.krokosha.quizyourself.utils.Validator

class LoginViewModel(private val repo: Repo, private val validator: Validator, private val mapper: DataMapper): ViewModel()
{
    private var _loadingStatus: MutableLiveData<LoadingStatus>? = MutableLiveData()
    private var _userLiveData: MutableLiveData<User>? = MutableLiveData()
    private var _openNextScreen: MutableLiveData<Boolean>? = MutableLiveData()
    
    //You need to observe this LiveData to get User from the response
    val userLiveData: LiveData<User>
        get() = _userLiveData!!
    
    //You need to observe this LiveData to get current LoadingStatus
    val loadingStatus: LiveData<LoadingStatus>
        get() = _loadingStatus!!
    
    //You need to observe this LiveData to get next screen that has to be opened
    val openNextScreen: LiveData<Boolean>
        get() = _openNextScreen!!
    
    private var async: AsyncTask<LoginRequest, Void, User>? = null
    
    @SuppressLint("StaticFieldLeak")
    fun executeLogin(username: String?, password: String?)
    {
        val request = LoginRequest(username.orEmpty(), password.orEmpty())
        
        if(validator.isValid(request))
        {
            async = object: AsyncTask<LoginRequest, Void, User>()
            {
                override fun onPreExecute()
                {
                    super.onPreExecute()
                    _loadingStatus!!.value = LoadingStatus.LOADING
                }
                
                override fun doInBackground(vararg p0: LoginRequest): User
                {
                    Thread.sleep(2500) //show loading
                    
                    return mapper.convert(repo.requestData(p0[0]))
                }
                
                override fun onPostExecute(result: User)
                {
                    super.onPostExecute(result)
                    _userLiveData!!.postValue(result)
                    _loadingStatus!!.postValue(LoadingStatus.SUCCESS)
                    _openNextScreen!!.postValue(true)
                }
                
            }.execute(request)
        }
        else
        {
            _loadingStatus!!.value = LoadingStatus.ERROR
        }
    }
    
    override fun onCleared()
    {
        super.onCleared()
        
        _loadingStatus = null
        _userLiveData = null
        _openNextScreen = null
        
        async?.let {
            if(it.isCancelled)
            {
                it.cancel(true)
            }
        }.also { async = null }
    }
}