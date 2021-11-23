package com.shusharin.movietest.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.shusharin.movietest.R
import com.shusharin.movietest.data.di.DaggerAppComponent
import com.shusharin.movietest.data.di.DatabaseModule
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    private val appComponent by lazy {
        DaggerAppComponent.builder()
            .databaseModule(DatabaseModule(application)).build()
    }
    private lateinit var adapter: RVadapter


    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()


        lifecycleScope.launchWhenStarted {
            mainViewModel.movieListFlow
                .onEach {
                    adapter.movieList = it

                }
                .collect()
        }

    }


    private fun setupRecyclerView() {
        val rvMovieList = findViewById<RecyclerView>(R.id.rvListMovie)
        adapter = RVadapter()
        rvMovieList.adapter = adapter


//        Слушатель на скролл
        rvMovieList.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            //            Определяет конец списка
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    mainViewModel.fetchNextPokemonList()
                }
            }
        })


    }


}
