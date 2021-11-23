package com.shusharin.movietest.presentation

import android.util.Log
import com.shusharin.movietest.domain.GetAllMoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

class MainViewModel @Inject constructor(private val getMoviesUseCase: GetAllMoviesUseCase) {



    private val movieFetchingIndex: MutableStateFlow<Int> = MutableStateFlow(0)
    val movieListFlow = movieFetchingIndex.flatMapLatest { page ->
        getMoviesUseCase(
            page = 0)
    }


    fun fetchNextPokemonList() {

            movieFetchingIndex.value +=20
        Log.d("TestIndex", "${movieFetchingIndex.value}")

    }


}