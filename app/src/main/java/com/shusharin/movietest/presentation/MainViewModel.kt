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

class MainViewModel(private val useCase: GetAllMoviesUseCase) : ViewModel() {


    fun getListMovie(){
        useCase()
    }



//    @Inject
//    lateinit var apiService: MovieApi
//
//    var movieListLD =  MutableLiveData<List<Movie>>()
//
//    init {
//        (application as MovieApp).appComponent.inject(this)
//
//    }
//

//
//    private val compositDisposable = CompositeDisposable()
//
//    private val _movieList = mutableListOf<Movie>()
//
//    var hasMore: Boolean? = null
//
//    // Определят страницу загрузки. В API параметр "offset" (20,40,60,80)
//    var page = 0
//    val offset = 20
//
//
//    fun getMovieListObserver(): LiveData<List<Movie>> {
//        return movieListLD
//    }
//
//    fun getMovieList() {
//        compositDisposable.add(apiService.getMovieList(page = page)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                hasMore = it.has_more
//                if (hasMore == true) page += offset
//                for (item in it.results) {
//                    val name = item.display_title
//                    val description = item.summary_short
//                    val poster = item.multimedia.src
//                    val movie = Movie(name, description, poster)
//                    _movieList.add(movie)
//                }
//
//                updateList()
//                Log.d("данные", "update list: ${movieListLD.value}")
//            },
//                {
//                    Log.d("данные", "Ошибка: $it")
//                })
//        )
//
//
//    }
//
//    override fun onCleared() {
//        compositDisposable.dispose()
//        super.onCleared()
//    }
//
//
//
//    fun updateList() {
//        movieListLD.value = _movieList.toList().distinct()
//    }

}