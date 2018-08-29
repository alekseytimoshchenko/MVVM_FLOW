package com.example.krokosha.quizyourself.di.scopes;

import com.example.krokosha.quizyourself.data.remote.eRetrofitModules;

import dagger.MapKey;

@MapKey
public @interface RetrofitModulesName {
	eRetrofitModules value();
}