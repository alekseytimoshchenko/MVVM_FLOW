package com.example.krokosha.quizyourself.deleteIt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.krokosha.quizyourself.R
import com.example.krokosha.quizyourself.ui.main.LoginFactory
import com.example.krokosha.quizyourself.ui.main.LoginViewModel

class MainActivityy: AppCompatActivity()
{
    lateinit var factory: LoginFactory
    
    private lateinit var model: LoginViewModel
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        model = ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)
        
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