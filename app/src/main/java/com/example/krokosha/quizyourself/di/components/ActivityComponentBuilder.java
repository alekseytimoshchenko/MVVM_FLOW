package com.example.krokosha.quizyourself.di.components;

import com.example.krokosha.quizyourself.di.moduls.ActivityModule;

/**
 * Created with care by Alexey.T
 * <p>
 * TODO: Add a class header comment!
 */
public interface ActivityComponentBuilder<C extends ActivityComponent, M extends ActivityModule>
{
	C build();
	
	ActivityComponentBuilder<C, M> module(M module);
}
