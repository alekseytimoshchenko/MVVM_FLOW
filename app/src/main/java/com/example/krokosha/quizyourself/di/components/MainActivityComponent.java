package com.example.krokosha.quizyourself.di.components;

import com.example.krokosha.quizyourself.di.moduls.MainActivityModule;
import com.example.krokosha.quizyourself.di.scopes.MainActivityScope;
import com.example.krokosha.quizyourself.ui.MainActivity;

import dagger.Subcomponent;

/**
 * Created with care by Alexey.T on 04/08/2018.
 * <p>
 * TODO: Add a class header comment!
 */
@MainActivityScope
@Subcomponent(modules = {MainActivityModule.class})
public interface MainActivityComponent extends ActivityComponent<MainActivity>
{
	@Subcomponent.Builder
	interface Builder extends ActivityComponentBuilder<MainActivityComponent, MainActivityModule>
	{
	
	}
}
