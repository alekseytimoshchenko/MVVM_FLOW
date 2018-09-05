package com.example.krokosha.quizyourself

import android.app.Application


/**
 * Created with care by Alexey.T on 27/08/2018.
 *
 * TODO: Add a class header comment!
 */
class App: Application()
{
    companion object
    {
        lateinit var instance: App
            private set
    }
    
    override fun onCreate()
    {
        super.onCreate()
        instance = this@App
    }
}