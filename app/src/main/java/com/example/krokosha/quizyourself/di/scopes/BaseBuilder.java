package com.example.krokosha.quizyourself.di.scopes;
/**
 * Created with care by Alexey.T
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface BaseBuilder {
}