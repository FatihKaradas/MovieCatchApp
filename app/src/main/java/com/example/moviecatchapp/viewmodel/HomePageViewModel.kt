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
    var recentMovieList : MutableLiveData<Movie>

    init {
        popularMovieList = MutableLiveData()
        recentMovieList = MutableLiveData()
    }

    fun getObserverLiveData(isPopular : Boolean):MutableLiveData<Movie>{
        if (isPopular) {
            return popularMovieList
        }else {
            return recentMovieList
        }
    }

    fun loadData(page: String,isPoular : Boolean){
        if (isPoular){
            repository.getPopularMovies(page, popularMovieList)
        }else{
            repository.getRecentMovies(page, recentMovieList)
        }
    }
}