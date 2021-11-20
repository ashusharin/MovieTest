package com.shusharin.movietest.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shusharin.movietest.data.api.MovieApi
import com.shusharin.movietest.data.api.MovieApp
import com.shusharin.movietest.data.di.AppComponent
import com.shusharin.movietest.domain.GetAllMoviesUseCase
import com.shusharin.movietest.domain.Movie
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val useCase: GetAllMoviesUseCase) {
    var listMovie: LiveData<List<Movie>> = useCase()


    fun getNextListMovie() {
        useCase()
    }


}