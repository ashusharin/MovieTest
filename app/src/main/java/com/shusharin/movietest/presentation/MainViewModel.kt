package com.shusharin.movietest.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shusharin.movietest.data.api.MovieApi
import com.shusharin.movietest.domain.Movie
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(application: Application) : AndroidViewModel(application) {


    private val compositDisposable = CompositeDisposable()

    private val _movieList = mutableListOf<Movie>()
    var movieListLD = MutableLiveData<List<Movie>>()

    var hasMore:Boolean? = null

    // Определят страницу загрузки. В API параметр "offset" (20,40,60,80)
    var page = 0
    val offset = 20

    override fun onCleared() {
        compositDisposable.dispose()
        super.onCleared()
    }

    fun getMovieList(movieApi: MovieApi) {
        compositDisposable.add(
            movieApi.getMovieList(page = page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("данные", "первый пошел")
                     hasMore = it.has_more
                    if (hasMore == true) page += offset
                    for (item in it.results) {
                        val name = item.display_title
                        val description = item.summary_short
                        val poster = item.multimedia.src
                        val movie = Movie(name, description, poster)
                        _movieList.add(movie)
                    }

                    updateList()
                    Log.d("данные", "update list: ${movieListLD.value}")
                },
                    {
                        Log.d("данные", "Ошибка: $it")
                    })
        )
    }


    fun updateList() {
        movieListLD.value = _movieList.toList().distinct()
    }

}