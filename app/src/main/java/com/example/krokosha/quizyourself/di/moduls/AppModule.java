package com.example.krokosha.quizyourself.di.moduls;

import android.content.Context;
import android.view.LayoutInflater;

import com.example.krokosha.quizyourself.di.components.ActivityComponentBuilder;
import com.example.krokosha.quizyourself.di.components.MainActivityComponent;
import com.example.krokosha.quizyourself.di.scopes.AppScope;
import com.example.krokosha.quizyourself.ui.MainActivity;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

/**
 * Created with care by Alexey.T
 * <p>
 * TODO: Add a class header comment!
 */
@Module(subcomponents = {//
		MainActivityComponent.class, //
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
	@ClassKey(MainActivity.class)
	ActivityComponentBuilder provideTimelineOfflineFragmentBuilder(MainActivityComponent.Builder iBuilder)
	{
		return iBuilder;
	}
}
