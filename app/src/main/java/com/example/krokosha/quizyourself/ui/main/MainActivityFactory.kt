package com.example.krokosha.quizyourself.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.krokosha.quizyourself.data.repo.MainActivityRepo
import com.example.krokosha.quizyourself.utils.DataMapper
import com.example.krokosha.quizyourself.utils.Validator

/**
 * Created with care by Alexey.T
 */
class MainActivityFactory(private val repo: MainActivityRepo, private val validator: Validator, private val mapper: DataMapper): ViewModelProvider.Factory
{
    override fun <T: ViewModel> create(modelClass: Class<T>): T
    {
        return modelClass.getConstructor(
                MainActivityRepo::class.java,
                Validator::class.java,
                DataMapper::class.java)
                .newInstance(repo, validator, mapper)
    }
}

//public class MainActivityFactory extends ViewModelProvider.NewInstanceFactory
//{
//	private MainActivityRepo mRepo;
//
//	public MainActivityFactory(final MainActivityRepo iRepo)
//	{
//		mRepo = iRepo;
//	}
//
//	@NonNull
//	@Override
//	public <T extends ViewModel> T create(@NonNull final Class<T> modelClass)
//	{
//		if (modelClass == MainActivityViewModel.class)
//		{
//			return (T) new MainActivityViewModel(mRepo);
//		}
//
//		return null;
//	}
//}