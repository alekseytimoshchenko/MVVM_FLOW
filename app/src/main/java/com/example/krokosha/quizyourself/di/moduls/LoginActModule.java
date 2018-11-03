package com.example.krokosha.quizyourself.di.moduls;

import com.example.krokosha.quizyourself.data.remote.LoginRestController;
import com.example.krokosha.quizyourself.data.repo.Repo;
import com.example.krokosha.quizyourself.ui.main.LoginFactory;
import com.example.krokosha.quizyourself.utils.DataMapper;
import com.example.krokosha.quizyourself.utils.Validator;

import dagger.Module;
import dagger.Provides;

/**
 * Created with care by Alexey.T on 20/08/2018.
 */
@Module
public class LoginActModule implements BaseModule
{
	@Provides
	LoginFactory getFactory(Repo iRepo, Validator iValidator, DataMapper iMapper)
	{
		return new LoginFactory(iRepo, iValidator, iMapper);
	}
	
	@Provides
	Repo getRepo(LoginRestController iController)
	{
		return new Repo(iController);
	}
	
	@Provides
	LoginRestController getController()
	{
		return new LoginRestController();
	}
	
	@Provides
	Validator getValidator()
	{
		return new Validator();
	}
	
	@Provides
	DataMapper getMapper()
	{
		return new DataMapper();
	}
}
