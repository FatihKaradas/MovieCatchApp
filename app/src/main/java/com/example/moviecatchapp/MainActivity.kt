package com.example.moviecatchapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.moviecatchapp.Model.Movie
import com.example.moviecatchapp.adapter.MovieAdapter
import com.example.moviecatchapp.viewmodel.HomePageViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var movieAdapter : MovieAdapter
    val viewModel by lazy {
        ViewModelProvider(this,defaultViewModelProviderFactory).get(HomePageViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        movieAdapter= MovieAdapter()
        recyclerView.adapter = movieAdapter

        viewModel.getObserverLiveData().observe(this,object : Observer<Movie>{
            override fun onChanged(t: Movie) {
                if (t != null){
                    movieAdapter.setList(t.results)
                }
            }
        })
        viewModel.loadPopularData("1")
    }
}