package com.example.krokosha.quizyourself.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.ContentLoadingProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.krokosha.quizyourself.App
import com.example.krokosha.quizyourself.R
import com.example.krokosha.quizyourself.ui.nextScreen.NextActivity
import com.example.krokosha.quizyourself.utils.LoadingStatus
import javax.inject.Inject

class LoginActivity: AppCompatActivity()
{
    private lateinit var tvUserName: TextView
    private lateinit var tvPassword: TextView
    private lateinit var pb: ContentLoadingProgressBar
    
    @Inject
    lateinit var factory: LoginFactory
    
    private lateinit var viewModel: LoginViewModel
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        App.instance.componentHolder.getBaseComponent(javaClass).inject(this)
        
        initViews()
        setListeners()
        
        viewModel = ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)
        
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
                    Toast.makeText(this, getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show()
                }
                else -> Log.e("TAG", getString(R.string.unexpected_case))
            }
        })
        
        viewModel.userLiveData.observe(this, Observer {
            Toast.makeText(this, getString(R.string.user_was_saved), Toast.LENGTH_SHORT).show()
        })
        
        viewModel.openNextScreen.observe(this, Observer {
            startActivity(NextActivity.newInstance(this))
        })
    }
    
    private fun initViews()
    {
        tvUserName = findViewById(R.id.et_login_act_user_name)
        tvPassword = findViewById(R.id.et_login_act_password)
        pb = findViewById(R.id.pb_login_act)
    }
    
    private fun setListeners()
    {
        findViewById<Button>(R.id.btn_login_act_sing_in).setOnClickListener {
            viewModel.executeLogin(tvUserName.text.toString(), tvPassword.text.toString())
        }
    }
    
    override fun onDestroy()
    {
        super.onDestroy()
        App.instance.componentHolder.releaseBaseComponent(LoginActivity::class.java)
    }
}
