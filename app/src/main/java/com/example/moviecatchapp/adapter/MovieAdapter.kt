package com.example.moviecatchapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ComputableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviecatchapp.Model.Result
import com.example.moviecatchapp.R

class MovieAdapter(private val isFirstScreen : Boolean = true): RecyclerView.Adapter<MovieAdapter.MyCustomHolder>() {

    var liveData: List<com.example.moviecatchapp.Model.Result>?=null;
    fun setList(liveData: List<com.example.moviecatchapp.Model.Result>){
        this.liveData=liveData
        notifyDataSetChanged()
    }
    class MyCustomHolder(val view:View):RecyclerView.ViewHolder(view)
    {
        val txtTitle = view.findViewById<TextView>(R.id.txtTitle)
        val txtGenre = view.findViewById<TextView>(R.id.txtGenre)
        val posterView = view.findViewById<ImageView>(R.id.posterView)
        fun bind(data:Result){
            txtTitle.text=data.title
            txtGenre.text="Denemem,Deneme,Deneme"
            Glide.with(posterView)
                .load("https://image.tmdb.org/t/p/w342" +data.poster_path)
                .into(posterView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MyCustomHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_movie_item,parent,false)
        return MyCustomHolder(view)
    }

    override fun onBindViewHolder(holder: MovieAdapter.MyCustomHolder, position: Int) {
            holder.bind(liveData!!.get(position))
    }

    override fun getItemCount(): Int {
            if (liveData == null){
                return 0
            }else if (isFirstScreen){
                return 4
            }else {
                return liveData!!.size
            }
    }

}