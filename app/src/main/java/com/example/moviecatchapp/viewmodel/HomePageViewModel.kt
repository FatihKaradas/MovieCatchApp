package com.example.moviecatchapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviecatchapp.Model.Movie
import com.example.moviecatchapp.di.Retrofit.RetrofitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(private val repository: RetrofitRepository) : ViewModel() {

    var popularMovieList : MutableLiveData<Movie>

    init {
        popularMovieList = MutableLiveData()
    }

    fun getObserverLiveData():MutableLiveData<Movie>{
        return popularMovieList
    }

    fun loadPopularData(page: String){
        repository.getPopularMovies(page , popularMovieList)
    }
}