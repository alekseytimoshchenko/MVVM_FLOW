package com.example.krokosha.quizyourself.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.krokosha.quizyourself.App
import com.example.krokosha.quizyourself.R
import javax.inject.Inject

/**
 * Implement navigation
 * */

class MainActivity: AppCompatActivity()
{
    @Inject
    lateinit var factory: MainActivityFactory
    
    private lateinit var model: MainActivityViewModel
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.instance.componentHolder.getActivityComponent(javaClass).inject(this@MainActivity)
        model = ViewModelProviders.of(this, factory).get(MainActivityViewModel::class.java)
        
        subscribe()
        model.requestData()
    }
    
    private fun subscribe()
    {
        model.contect.observe(this, Observer {
            print(it.toString())
        })
    }
    
    override fun onDestroy()
    {
        super.onDestroy()
        App.instance.componentHolder.releaseActivityComponent(javaClass)
    }
}
