package com.example.krokosha.quizyourself.di.components;

import com.example.krokosha.quizyourself.di.moduls.LoginActModule;
import com.example.krokosha.quizyourself.di.scopes.LoginActScope;
import com.example.krokosha.quizyourself.ui.main.LoginActivity;

import dagger.Subcomponent;

/**
 * Created with care by Alexey.T on 04/08/2018.
 */
@LoginActScope
@Subcomponent(modules = {LoginActModule.class})
public interface LoginActComponent extends BaseComponent<LoginActivity>
{
	@Subcomponent.Builder
	interface Builder extends BaseComponentBuilder<LoginActComponent, LoginActModule>
	{
	
	}
}
