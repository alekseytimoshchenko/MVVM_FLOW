package com.example.krokosha.quizyourself.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.crashlytics.android.Crashlytics
import com.example.krokosha.quizyourself.R
import io.fabric.sdk.android.Fabric

/**
 * 3) Leak Canary implementation
 * 4) di configuration
 * 5) fix manifest file
 * */

class MainActivity: AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Fabric.with(this, Crashlytics())
    }
}
