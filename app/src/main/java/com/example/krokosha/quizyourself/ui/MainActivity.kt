package com.example.krokosha.quizyourself.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.krokosha.quizyourself.App
import com.example.krokosha.quizyourself.R
import com.example.krokosha.quizyourself.data.remote.endpoints.IMovieEndpoint
import javax.inject.Inject

/**
 * 7) Retrofit
 * 8) ViewModel
 * */

class MainActivity: AppCompatActivity()
{
    @Inject
    lateinit var context: Context
    
    @Inject
    lateinit var apiInterface: IMovieEndpoint
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.instance.componentHolder.getActivityComponent(javaClass).inject(this@MainActivity)
    }
    
    override fun onDestroy()
    {
        super.onDestroy()
        App.instance.componentHolder.releaseActivityComponent(javaClass)
    }
}
