package com.example.krokosha.quizyourself.ui.main

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.ContentLoadingProgressBar
import androidx.lifecycle.Observer
import com.example.krokosha.quizyourself.R
import javax.inject.Inject


/**
 * Implement navigation
 * */

class MainActivity: AppCompatActivity()
{
    private lateinit var tvUserName: TextView
    private lateinit var tvPassword: TextView
    private lateinit var pb: ContentLoadingProgressBar
    
    @Inject
    lateinit var factory: MainActivityFactory
    
    private lateinit var viewModel: MainActivityViewModel
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        initViews()
        setListeners()
        
        observeLiveData()
    }
    
    private fun observeLiveData()
    {
        viewModel.loadingStatus.observe(this, Observer {
            //Loading status presentation
        })
        
        viewModel.userLiveData.observe(this, Observer {
            //Save user data
        })
    }
    
    private fun initViews()
    {
        tvUserName = findViewById(R.id.et_main_act_user_name)
        tvPassword = findViewById(R.id.et_main_act_password)
        pb = findViewById(R.id.pb_main_act)
    }
    
    private fun setListeners()
    {
        findViewById<Button>(R.id.btn_main_act_sing_in).setOnClickListener {
            viewModel.executeLogin(tvUserName.text.toString(), tvPassword.text.toString())
        }
    }
}
