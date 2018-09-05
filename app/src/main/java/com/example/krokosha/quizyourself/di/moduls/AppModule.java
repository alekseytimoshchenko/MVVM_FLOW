package com.example.krokosha.quizyourself.di.moduls;

import android.content.Context;

import com.example.krokosha.quizyourself.di.components.BaseComponentBuilder;
import com.example.krokosha.quizyourself.di.components.LoginActComponent;
import com.example.krokosha.quizyourself.di.scopes.AppScope;
import com.example.krokosha.quizyourself.ui.main.LoginActivity;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

/**
 * Created with care by Alexey.T on 04/08/2018.
 * <p>
 * TODO: Add a class header comment!
 */
@Module(subcomponents = {//
		LoginActComponent.class, //
})
public class AppModule
{
	private final Context context;
	
	public AppModule(Context context)
	{
		this.context = context;
	}
	
	@AppScope
	@Provides
	Context provideContext()
	{
		return context;
	}
	
	@Provides
	@IntoMap
	@ClassKey(LoginActivity.class)
	BaseComponentBuilder provideTimelineOfflineFragmentBuilder(LoginActComponent.Builder builder)
	{
		return builder;
	}
}
