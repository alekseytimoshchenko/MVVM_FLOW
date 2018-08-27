package com.example.krokosha.quizyourself

import android.app.Application
import com.facebook.stetho.Stetho

/**
 * Created with care by Alexey.T on 27/08/2018.
 *
 * TODO: Add a class header comment!
 */
class App: Application()
{
    override fun onCreate()
    {
        super.onCreate()
        initStetho()
    }
    
    private fun initStetho()
    {
        Stetho.initializeWithDefaults(this)
    }
}