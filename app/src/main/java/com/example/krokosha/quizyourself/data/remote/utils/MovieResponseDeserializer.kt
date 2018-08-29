package com.example.krokosha.quizyourself.data.remote.utils

import com.example.krokosha.quizyourself.data.remote.model.MovieResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created with care by Alexey.T
 *
 * TODO: Add a class header comment!
 */

class MovieResponseDeserializer : JsonAdapter<MovieResponse>()
{
    override fun fromJson(reader: JsonReader): MovieResponse
    {
        var runActionResponse = MovieResponse()
    
        Observable.just(reader) //
                .subscribeOn(Schedulers.computation()) //
                .observeOn(AndroidSchedulers.mainThread()) //
                .map {
                    Moshi.Builder().build().adapter(MovieResponse::class.java).fromJson(it)!!
                } //
                .blockingSubscribe { //
                    runActionResponse = it //
                } //
    
        return runActionResponse
    }
    
    override fun toJson(writer: JsonWriter, value: MovieResponse?)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}