package com.example.krokosha.quizyourself.di.components;

import com.example.krokosha.quizyourself.di.moduls.BaseModule;

/**
 * Created with care by Alexey.T on 04/08/2018.
 * <p>
 * TODO: Add a class header comment!
 */
public interface BaseComponentBuilder<C extends BaseComponent, M extends BaseModule>
{
	C build();
	
	BaseComponentBuilder<C, M> module(M module);
}
