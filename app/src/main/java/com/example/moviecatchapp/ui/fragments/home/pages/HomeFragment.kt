package com.example.moviecatchapp.ui.fragments.home.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviecatchapp.Model.Movie
import com.example.moviecatchapp.adapter.MovieAdapter
import com.example.moviecatchapp.adapter.RecentAdapter
import com.example.moviecatchapp.databinding.FragmentHomeBinding
import com.example.moviecatchapp.viewmodel.HomePageViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var movieAdapter : MovieAdapter
    private lateinit var recentMovieAdapter : RecentAdapter

    val viewModel by lazy {
        ViewModelProvider(this,defaultViewModelProviderFactory).get(HomePageViewModel::class.java)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        initRecyclerViews()

        viewModel.getObserverLiveData(true).observe(viewLifecycleOwner,object : Observer<Movie> {
            override fun onChanged(t: Movie) {
                if (t != null){
                    movieAdapter.setList(t.results)
                }
            }
        })
        viewModel.getObserverLiveData(false).observe(viewLifecycleOwner,object : Observer<Movie> {
            override fun onChanged(t: Movie) {
                if (t != null){
                    recentMovieAdapter.setList(t.results)
                }
            }
        })
        fetchMovies()

        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun initRecyclerViews(){
        val lmHorizontal = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        val lmVertical = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        binding.RecentrecyclerView.layoutManager = lmVertical
        binding.recyclerView.layoutManager = lmHorizontal
        recentMovieAdapter = RecentAdapter()
        movieAdapter= MovieAdapter()
        binding.recyclerView.adapter = movieAdapter
        binding.RecentrecyclerView.adapter = recentMovieAdapter
    }

    fun fetchMovies(){

        CoroutineScope(Dispatchers.IO).launch {

            val job1 : Deferred<Unit> = async {

                viewModel.loadData("1",true)
            }
            val job2 : Deferred<Unit> = async {

                viewModel.loadData("1",false)
            }

            job1.await()
            job2.await()
        }
    }
}