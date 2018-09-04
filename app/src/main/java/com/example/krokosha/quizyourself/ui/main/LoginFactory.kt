package com.example.krokosha.quizyourself.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.krokosha.quizyourself.data.repo.Repo
import com.example.krokosha.quizyourself.utils.DataMapper
import com.example.krokosha.quizyourself.utils.Validator

/**
 * Created with care by Alexey.T
 */
class LoginFactory(private val repo: Repo, private val validator: Validator, private val mapper: DataMapper): ViewModelProvider.Factory
{
    override fun <T: ViewModel> create(modelClass: Class<T>): T
    {
        return modelClass.getConstructor(
                Repo::class.java,
                Validator::class.java,
                DataMapper::class.java)
                .newInstance(repo, validator, mapper)
    }
}