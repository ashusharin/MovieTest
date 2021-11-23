package com.shusharin.movietest.data.api

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.shusharin.movietest.domain.Movie
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onSuccess
import com.skydoves.sandwich.suspendOnSuccess
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

class PageSource @AssistedInject constructor(
    private val movieApi: MovieApi,
) : PagingSource<Int, Movie>() {


    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page: Int = params.key ?: 1


        val responseApi = movieApi.getMovieList(page = page*20)

        if (responseApi.isSuccessful) {
            val movies = checkNotNull(responseApi.body()).results
                .map {
                    Movie(it.display_title, it.summary_short, checkNotNull(it.multimedia.src) , page)
                }
            val nextKey = if (responseApi.body()!!.has_more) page + 1 else null
            val prevkey = if (page == 1) null else page - 1
            return LoadResult.Page(movies, prevkey, nextKey)
        } else {
            return LoadResult.Error(HttpException(responseApi))
        }

    }

    @AssistedFactory
    interface Factory {

        fun create(): PageSource
    }
}
