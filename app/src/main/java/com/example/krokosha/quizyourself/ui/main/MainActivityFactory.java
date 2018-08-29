package com.example.krokosha.quizyourself.ui.main;

import com.example.krokosha.quizyourself.data.repo.MainActivityRepo;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created with care by Alexey.T
 */
public class MainActivityFactory extends ViewModelProvider.NewInstanceFactory
{
	private MainActivityRepo mRepo;
	
	public MainActivityFactory(final MainActivityRepo iRepo)
	{
		mRepo = iRepo;
	}
	
	@NonNull
	@Override
	public <T extends ViewModel> T create(@NonNull final Class<T> modelClass)
	{
		if (modelClass == MainActivityViewModel.class)
		{
			return (T) new MainActivityViewModel(mRepo);
		}
		
		return null;
	}
}