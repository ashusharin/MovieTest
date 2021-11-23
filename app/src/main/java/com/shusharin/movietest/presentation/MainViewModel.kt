package com.shusharin.movietest.presentation

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.shusharin.movietest.data.api.PageSource
import com.shusharin.movietest.domain.GetAllMoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import javax.inject.Provider

class MainViewModel @Inject constructor(
    private val getMoviesUseCase: GetAllMoviesUseCase,
    private val pagingSourceFactory: PageSource.Factory,
) : ViewModel() {


    val movieList = Pager(PagingConfig(pageSize = 5)) {
        pagingSourceFactory.create()
    }.flow
        .stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())


    class Factory @Inject constructor(
        private val viewModerProvider: Provider<MainViewModel>,
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            require(modelClass == MainViewModel::class.java)
            return viewModerProvider.get() as T
        }
    }
}