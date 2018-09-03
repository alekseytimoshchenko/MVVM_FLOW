package com.example.krokosha.quizyourself.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.ContentLoadingProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.krokosha.quizyourself.R
import com.example.krokosha.quizyourself.data.remote.MainRestController
import com.example.krokosha.quizyourself.data.repo.MainActivityRepo
import com.example.krokosha.quizyourself.utils.DataMapper
import com.example.krokosha.quizyourself.utils.LoadingStatus
import com.example.krokosha.quizyourself.utils.Validator
import com.google.android.material.snackbar.Snackbar


/**
 * Implement navigation
 * */

class MainActivity: AppCompatActivity()
{
    private lateinit var tvUserName: TextView
    private lateinit var tvPassword: TextView
    private lateinit var pb: ContentLoadingProgressBar
    
//    lateinit var factory: MainActivityFactory
    
    private lateinit var viewModel: MainActivityViewModel
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        initViews()
        setListeners()
        
        val api = MainRestController()
        val repo = MainActivityRepo(api)
        val validator = Validator()
        val mapper = DataMapper()
        val factory = MainActivityFactory(repo, validator, mapper)
        
        viewModel = ViewModelProviders.of(this, factory).get(MainActivityViewModel::class.java)
        
        observeLiveData()
    }
    
    private fun observeLiveData()
    {
        viewModel.loadingStatus.observe(this, Observer {
            when(it){
                LoadingStatus.LOADING -> pb.show()
                LoadingStatus.SUCCESS -> pb.hide()
                LoadingStatus.ERROR -> {
                    pb.hide()
                    Snackbar.make(pb, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
                }
                else -> Log.e("TAG", "Unexpected case")
            }
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
