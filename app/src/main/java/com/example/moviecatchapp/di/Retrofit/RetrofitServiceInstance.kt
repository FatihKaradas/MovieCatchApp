package com.example.moviecatchapp.di.Retrofit

import com.example.moviecatchapp.Model.Movie
import com.example.moviecatchapp.Model.Trailer
import com.example.moviecatchapp.Model.Genre
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitServiceInstance {

    @GET("3/movie/popular?api_key=32e81e49f5bbfb435d3616f16196bdd5")
    fun getPopularVideos(@Query("page") query: String) : Call<Movie>

    @GET("3/movie/now_playing?api_key=32e81e49f5bbfb435d3616f16196bdd5")
    fun getRecentVideos(@Query("page") query: String) : Call<Movie>

    @GET("3/genre/movie/list?api_key=32e81e49f5bbfb435d3616f16196bdd5")
    fun getGenres() : Call<Genre>

    @GET("3/movie/{id}/videos?api_key=32e81e49f5bbfb435d3616f16196bdd5")
    fun getTrailerTeasers(@Path("id") id:Int) : Call<Trailer>

    @GET("3/search/movie?api_key=32e81e49f5bbfb435d3616f16196bdd5")
    fun getSuggestions(@Query("query") query: String) : Call<Movie>

}