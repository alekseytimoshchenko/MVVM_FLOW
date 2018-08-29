package com.example.krokosha.quizyourself.di.moduls;

import android.content.Context;

import com.example.krokosha.quizyourself.BuildConfig;
import com.example.krokosha.quizyourself.data.remote.ApiInterceptor;
import com.example.krokosha.quizyourself.data.remote.eRetrofitModules;
import com.example.krokosha.quizyourself.data.remote.model.MovieResponse;
import com.example.krokosha.quizyourself.data.remote.utils.MovieResponseDeserializer;
import com.example.krokosha.quizyourself.di.components.ActivityComponentBuilder;
import com.example.krokosha.quizyourself.di.components.MainActivityComponent;
import com.example.krokosha.quizyourself.di.scopes.AppScope;
import com.example.krokosha.quizyourself.di.scopes.BaseBuilder;
import com.example.krokosha.quizyourself.di.scopes.RetrofitModulesName;
import com.example.krokosha.quizyourself.ui.main.MainActivity;
import com.example.krokosha.quizyourself.utils.Constants;
import com.squareup.moshi.Moshi;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

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
	
	//Network
	
	@AppScope
	@Provides
	HttpLoggingInterceptor provideLoggingInterceptor()
	{
		HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		return interceptor;
	}
	
	@AppScope
	@Provides
	ApiInterceptor provideApiInterceptor()
	{
		return new ApiInterceptor();
	}
	
	@AppScope
	@Provides
	Cache provideCache(Context iC)
	{
		long cacheSize = 5 * 1024 * 1024;
		File cacheDir = iC.getCacheDir();
		return new Cache(cacheDir, cacheSize);
	}
	
	@AppScope
	@Provides
	RxJava2CallAdapterFactory provideRxJavaCallAdapterFactory()
	{
		return RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io());
	}
	
	@AppScope
	@Provides
	@BaseBuilder
	Retrofit.Builder getBaseBuilder()
	{
		return new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL);
	}
	
	@AppScope
	@Provides
	OkHttpClient provideBaseHttpClient(HttpLoggingInterceptor loggingInterceptor,//
	                                   Cache cache,//
	                                   ApiInterceptor apiInterceptor)
	{
		return new OkHttpClient.Builder().addInterceptor(loggingInterceptor) //
		                                 .addInterceptor(apiInterceptor) //
		                                 .connectTimeout(Constants.TIMEOUT_IN_MS, TimeUnit.MILLISECONDS) //
		                                 .cache(cache) //
		                                 .build();
	}
	
	@AppScope
	@Provides
	Moshi providesMoshi()
	{
		return new Moshi.Builder().add(MovieResponse.class, new MovieResponseDeserializer()).build();
	}
	
	@AppScope
	@Provides
	@IntoMap
	@RetrofitModulesName(eRetrofitModules.MOVIE)
	Retrofit retrofitRunActivity(OkHttpClient okHttpClient,
	                             RxJava2CallAdapterFactory rxAdaptor,
	                             Moshi moshi,
	                             @BaseBuilder Retrofit.Builder iBuilder)
	{
		return iBuilder.addConverterFactory(MoshiConverterFactory.create(moshi)) //mapper
		               .addCallAdapterFactory(rxAdaptor) //
		               .client(okHttpClient) //
		               .build();
	}
	
	@Provides
	@IntoMap
	@ClassKey(MainActivity.class)
	ActivityComponentBuilder provideTimelineOfflineFragmentBuilder(MainActivityComponent.Builder iBuilder)
	{
		return iBuilder;
	}
	
}
