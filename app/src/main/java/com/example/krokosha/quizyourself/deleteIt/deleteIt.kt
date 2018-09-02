package com.example.krokosha.quizyourself.deleteIt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.krokosha.quizyourself.R
import com.example.krokosha.quizyourself.ui.main.MainActivityFactory
import com.example.krokosha.quizyourself.ui.main.MainActivityViewModel

class MainActivityy: AppCompatActivity()
{
    lateinit var factory: MainActivityFactory
    
    private lateinit var model: MainActivityViewModel
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model = ViewModelProviders.of(this, factory).get(MainActivityViewModel::class.java)
        
        subscribe()
    }
    
    private fun subscribe()
    {
    }
    
    override fun onDestroy()
    {
        super.onDestroy()
    }
}