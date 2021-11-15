package com.shusharin.movietest.presentation

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_SETTLING
import com.shusharin.movietest.R
import com.shusharin.movietest.data.api.MovieApi
import com.shusharin.movietest.data.api.MovieApp
import okhttp3.internal.notifyAll

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel

    private lateinit var adapter: RVadapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
    }


    override fun onCreateView(
        parent: View?,
        name: String,
        context: Context,
        attrs: AttributeSet,
    ): View? {
        mainViewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.getMovieList((application as MovieApp).movieApi)
        mainViewModel.movieListLD.observe(this) {
            Log.d("ресв", "список в адаптер: $it")
            adapter.movieList = it
        }


        return super.onCreateView(parent, name, context, attrs)
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
                    Log.d("скролл", "конец списка")
                    mainViewModel.getMovieList((application as MovieApp).movieApi)


                }
            }
        })


    }


}
