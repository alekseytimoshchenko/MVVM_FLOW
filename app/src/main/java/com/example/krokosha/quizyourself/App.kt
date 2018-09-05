package com.example.krokosha.quizyourself

import android.app.Application
import com.example.krokosha.quizyourself.di.ComponentsHolder

/**
 * Created with care by Alexey.T on 27/08/2018.
 *
 * TODO: Add a class header comment!
 */
class App: Application()
{
    lateinit var componentHolder: ComponentsHolder
    
    companion object
    {
        lateinit var instance: App
            private set
    }
    
    override fun onCreate()
    {
        super.onCreate()
        instance = this@App
        componentHolder = ComponentsHolder(this).init()
    }
}