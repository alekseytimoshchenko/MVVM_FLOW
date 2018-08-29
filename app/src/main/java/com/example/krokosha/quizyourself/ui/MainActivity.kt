package com.example.krokosha.quizyourself.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.krokosha.quizyourself.App
import com.example.krokosha.quizyourself.R
import javax.inject.Inject

/**
 * 6) SingleLiveEvent
 * */

class MainActivity: AppCompatActivity()
{
    @Inject
    lateinit var context: Context
    
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
