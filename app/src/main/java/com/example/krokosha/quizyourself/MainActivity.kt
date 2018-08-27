package com.example.krokosha.quizyourself

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * 1) Need to provide Stetho implementation
 * 2) Timber implementation
 * 3) Leak Canary implementation
 * */

class MainActivity: AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
