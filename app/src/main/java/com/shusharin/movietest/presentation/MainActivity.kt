package com.shusharin.movietest.presentation

import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.shusharin.movietest.R
import com.shusharin.movietest.data.di.DaggerAppComponent
import com.shusharin.movietest.data.di.DatabaseModule
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelProvider: Provider<MainViewModel.Factory>

    private val mainViewModel: MainViewModel by viewModels { viewModelProvider.get() }

    private val appComponent by lazy {
        DaggerAppComponent.builder()
            .databaseModule(DatabaseModule(application)).build()
    }
    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        RVadapter()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        lifecycleScope.launchWhenStarted {
            mainViewModel.movieList.collectLatest(adapter::submitData)
        }

    }


    private fun setupRecyclerView() {
        val rvMovieList = findViewById<RecyclerView>(R.id.rvListMovie)
        val progressBar = findViewById<ProgressBar>(R.id.progress)

        rvMovieList.adapter = adapter.withLoadStateHeaderAndFooter(
            header = LoaderStateAdapter(),
            footer = LoaderStateAdapter()
        )
        adapter.addLoadStateListener { state ->

            rvMovieList.isVisible = state.refresh != LoadState.Loading
            progressBar.isVisible = state.refresh == LoadState.Loading
        }
    }





}



