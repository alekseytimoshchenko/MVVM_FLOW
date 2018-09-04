package com.example.krokosha.quizyourself.ui.nextScreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.krokosha.quizyourself.R

class NextActivity: AppCompatActivity()
{
    
    companion object
    {
        fun newInstance(iC: Context) = Intent(iC, NextActivity::class.java)
    }
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
    }
}
