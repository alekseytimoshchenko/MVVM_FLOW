//package com.example.krokosha.quizyourself.di;
//
//import android.content.Context;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.inject.Inject;
//import javax.inject.Provider;
//
//import data.local.basic.AppDatabase;
//import di.components.ActivityComponent;
//import di.components.ActivityComponentBuilder;
//import di.components.AppComponent;
//import di.components.DaggerAppComponent;
//import di.moduls.ActivityModule;
//import di.moduls.AppModule;
//
//public class ComponentsHolder
//{
//	private final Context context;
//	private final AppDatabase mDB;
//
//	@Inject
//	Map<Class<?>, Provider<ActivityComponentBuilder>> builders;
//
//	private Map<Class<?>, ActivityComponent> components;
//	private AppComponent appComponent;
//
//	public ComponentsHolder(Context context, AppDatabase iDB)
//	{
//		this.context = context;
//		mDB = iDB;
//	}
//
//	public ComponentsHolder init()
//	{
//		appComponent = DaggerAppComponent.builder().appModule(new AppModule(context, mDB)).build();
//		appComponent.injectComponentsHolder(this);
//		components = new HashMap<>();
//		return this;
//	}
//
//	public AppComponent getAppComponent()
//	{
//		return appComponent;
//	}
//
//	public ActivityComponent getActivityComponent(Class<?> cls)
//	{
//		return getActivityComponent(cls, null);
//	}
//
//	public ActivityComponent getActivityComponent(Class<?> cls, ActivityModule module)
//	{
//		ActivityComponent component = components.get(cls);
//
//		if (component == null)
//		{
//			ActivityComponentBuilder builder = builders.get(cls).get();
//
//			if (module != null)
//			{
//				builder.module(module);
//			}
//
//			component = builder.build();
//			components.put(cls, component);
//		}
//
//		return component;
//	}
//
//	public void releaseActivityComponent(Class<?> cls)
//	{
//		components.put(cls, null);
//	}
//}
