package com.example.krokosha.quizyourself.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.krokosha.quizyourself.R

/**
 * 1) Need to provide Stetho implementation
 * 2) Timber implementation
 * 3) Leak Canary implementation
 * 4) di configuration
 * */

class MainActivity: AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
