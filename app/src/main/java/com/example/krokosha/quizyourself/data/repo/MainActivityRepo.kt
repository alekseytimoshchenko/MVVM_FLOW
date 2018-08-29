package com.example.krokosha.quizyourself.data.repo

import com.example.krokosha.quizyourself.data.remote.endpoints.IMovieEndpoint
import com.example.krokosha.quizyourself.data.remote.model.MovieResponse
import com.example.krokosha.quizyourself.utils.Constants
import io.reactivex.schedulers.Schedulers

/**
 * Created with care by Alexey.T
 */
class MainActivityRepo(private val apiInterface: IMovieEndpoint)
{
    fun requestData(): MovieResponse
    {
        return apiInterface.getMovie(Constants.API_KEY, page = 0) //
                .subscribeOn(Schedulers.io()) //
                .onErrorReturn { MovieResponse(999, 1000) }//
                .blockingFirst()
    }
}