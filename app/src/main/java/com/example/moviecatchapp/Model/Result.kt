package com.example.moviecatchapp.Model

data class Result(
    val backdrop_path : String,
    val genre_ids: List<Int>,
    val id : Int,
    val overview : String,
    val popularity: Double,
    val poster_path : String,
    val realase_date : String,
    val title : String,
    val vote_average : Double,
    var genrestringTr: String,
    var genrestring : String
)