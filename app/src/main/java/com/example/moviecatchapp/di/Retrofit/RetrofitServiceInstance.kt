package com.example.moviecatchapp.di.Retrofit

import com.example.moviecatchapp.Model.Movie
import com.example.moviecatchapp.Model.Trailer
import com.example.moviecatchapp.Model.Genre
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitServiceInstance {

    @GET("3/movie/popular?api_key=802b2c4b88ea1183e50e6b285a2769e")
    fun getPopularVideos(@Query("page") query: String) : Call<Movie>

    @GET("3/movie/now_playing?api_key=802b2c4b88ea1183e50e6b285a2769e")
    fun getRecentVideos(@Query("page") query: String) : Call<Movie>

    @GET("3/genre/movie/list?api_key=802b2c4b88ea1183e50e6b285a2769e")
    fun getGenres() : Call<Genre>

    @GET("3/movie/{id}/videos?api_key=802b2c4b88ea1183e50e6b285a2769e")
    fun getTrailerTeasers(@Path("id") id:Int) : Call<Trailer>

    @GET("3/search/movie?api_key=802b2c4b88ea1183e50e6b285a2769e")
    fun getSuggestions(@Query("query") query: String) : Call<Movie>

}