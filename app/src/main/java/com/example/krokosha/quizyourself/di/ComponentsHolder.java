package com.example.krokosha.quizyourself.di;

import android.content.Context;

import com.example.krokosha.quizyourself.di.components.AppComponent;
import com.example.krokosha.quizyourself.di.components.BaseComponent;
import com.example.krokosha.quizyourself.di.components.BaseComponentBuilder;
import com.example.krokosha.quizyourself.di.components.DaggerAppComponent;
import com.example.krokosha.quizyourself.di.moduls.AppModule;
import com.example.krokosha.quizyourself.di.moduls.BaseModule;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

public class ComponentsHolder
{
	private final Context context;
	
	@Inject
	Map<Class<?>, Provider<BaseComponentBuilder>> builders;
	
	private Map<Class<?>, BaseComponent> components;
	private AppComponent appComponent;
	
	public ComponentsHolder(Context context)
	{
		this.context = context;
	}
	
	public ComponentsHolder init()
	{
		appComponent = DaggerAppComponent.builder().appModule(new AppModule(context)).build();
		appComponent.injectComponentsHolder(this);
		components = new HashMap<>();
		return this;
	}
	
	public BaseComponent getBaseComponent(Class<?> cls)
	{
		return getBaseComponent(cls, null);
	}
	
	public BaseComponent getBaseComponent(Class<?> cls, BaseModule module)
	{
		BaseComponent component = components.get(cls);
		
		if (component == null)
		{
			BaseComponentBuilder builder = builders.get(cls).get();
			
			if (module != null)
			{
				builder.module(module);
			}
			
			component = builder.build();
			components.put(cls, component);
		}
		
		return component;
	}
	
	public void releaseBaseComponent(Class<?> cls)
	{
		components.put(cls, null);
	}
}
