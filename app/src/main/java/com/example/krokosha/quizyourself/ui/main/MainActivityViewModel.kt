package com.example.krokosha.quizyourself.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krokosha.quizyourself.data.remote.model.MovieResponse
import com.example.krokosha.quizyourself.data.repo.MainActivityRepo
import com.example.krokosha.quizyourself.utils.androidComponents.SingleLiveEvent

/**
 * Created with care by Alexey.T on 29/08/2018.
 */

class MainActivityViewModel(private val repo: MainActivityRepo): ViewModel()
{
    private val _loadingStatus = SingleLiveEvent<Boolean>()
    
    val loadingStatus: SingleLiveEvent<Boolean>
        get() = _loadingStatus
    
    private val _content = MutableLiveData<MovieResponse>()
    
    val contect: LiveData<MovieResponse>
        get() = _content
    
    fun requestData()
    {
        _content.postValue(repo.requestData())
    }
}