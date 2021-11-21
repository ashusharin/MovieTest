package com.shusharin.movietest.presentation

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.shusharin.movietest.R
import com.shusharin.movietest.data.di.DaggerAppComponent
import com.shusharin.movietest.data.di.DataModul
import com.shusharin.movietest.data.di.DatabaseModule
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
    }


    override fun onCreateView(
        parent: View?,
        name: String,
        context: Context,
        attrs: AttributeSet,
    ): View? {

        mainViewModel.listMovie.observe(this) {
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
                    mainViewModel.getNextListMovie()
                }
            }
        })


    }


}
