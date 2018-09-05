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
 * <p>
 * TODO: Add a class header comment!
 */
@Module
public class LoginActModule implements BaseModule
{
	@di.scopes.LoginActScope
	@Provides
	LoginFactory getFactory(Repo iRepo, Validator iValidator, DataMapper iMapper)
	{
		return new LoginFactory(iRepo, iValidator, iMapper);
	}
	
	@di.scopes.LoginActScope
	@Provides
	Repo getRepo(LoginRestController iController)
	{
		return new Repo(iController);
	}
	
	@di.scopes.LoginActScope
	@Provides
	LoginRestController getController()
	{
		return new LoginRestController();
	}
	
	@di.scopes.LoginActScope
	@Provides
	Validator getValidator()
	{
		return new Validator();
	}
	
	@di.scopes.LoginActScope
	@Provides
	DataMapper getMapper()
	{
		return new DataMapper();
	}
	
}
