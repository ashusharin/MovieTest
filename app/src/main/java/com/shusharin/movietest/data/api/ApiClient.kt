package com.shusharin.movietest.data.api

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shusharin.movietest.R
import com.shusharin.movietest.domain.Movie
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class ApiClient @Inject constructor(
    private val movieApi: MovieApi,
) {
    var movieListLD = MutableLiveData<List<Movie>>()
    private val _movieList = mutableListOf<Movie>()
    var hasMore: Boolean? = null
    val offset = 20
    var page: Int = 0



    fun getMovies(): LiveData<List<Movie>> {

//        val d = Log.d("тестирование",
//            "Api.service().getMovies() ||| ${application.getString(R.string.app_name)}")
       val compositDisposable =  movieApi.getMovieList(page = page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
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
        return movieListLD
    }

    private fun updateList() {
        movieListLD.value = _movieList.toList().distinct()
    }


}
