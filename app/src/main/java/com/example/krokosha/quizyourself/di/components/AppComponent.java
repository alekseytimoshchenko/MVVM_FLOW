package com.example.krokosha.quizyourself.di.components;

import com.example.krokosha.quizyourself.di.ComponentsHolder;
import com.example.krokosha.quizyourself.di.moduls.AppModule;
import com.example.krokosha.quizyourself.di.scopes.AppScope;

import dagger.Component;

/**
 * Created with care by Alexey.T on 04/08/2018.
 * <p>
 * TODO: Add a class header comment!
 */
@AppScope
@Component(modules = AppModule.class)
public interface AppComponent
{
	void injectComponentsHolder(ComponentsHolder componentsHolder);
}
