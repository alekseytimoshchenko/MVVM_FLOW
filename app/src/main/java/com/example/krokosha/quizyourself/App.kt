package com.example.krokosha.quizyourself

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.example.krokosha.quizyourself.utils.CrashReportingTree
import com.facebook.stetho.Stetho
import io.fabric.sdk.android.Fabric
import timber.log.Timber



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
        initTimberWithCrashlitics()
    }
    
    private fun initStetho()
    {
        Stetho.initializeWithDefaults(this)
    }
    
    private fun initTimberWithCrashlitics()
    {
        Timber.plant(if(BuildConfig.DEBUG) Timber.DebugTree()
        else CrashReportingTree())
    
        Fabric.with(this, Crashlytics())
    }
}