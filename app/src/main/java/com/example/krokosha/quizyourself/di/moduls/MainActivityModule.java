package com.example.krokosha.quizyourself.di.moduls;

import com.example.krokosha.quizyourself.data.remote.eRetrofitModules;
import com.example.krokosha.quizyourself.data.remote.endpoints.IMovieEndpoint;
import com.example.krokosha.quizyourself.di.scopes.MainActivityScope;

import java.util.Map;

import javax.inject.Provider;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created with care by Alexey.T
 * <p>
 * TODO: Add a class header comment!
 */
@Module
public class MainActivityModule implements ActivityModule
{
	@MainActivityScope
	@Provides
	IMovieEndpoint getMovieEndpoint(Map<eRetrofitModules, Provider<Retrofit>> iRetrofitModules)
	{
		return iRetrofitModules.get(eRetrofitModules.MOVIE).get().create(IMovieEndpoint.class);
	}
}
