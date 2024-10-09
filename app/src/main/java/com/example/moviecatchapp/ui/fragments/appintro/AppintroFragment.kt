package com.example.moviecatchapp.ui.fragments.appintro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moviecatchapp.adapter.ViewPagerAdapter
import com.example.moviecatchapp.databinding.FragmentAppintroBinding
import com.example.moviecatchapp.ui.fragments.appintro.Pages.FifthFragment
import com.example.moviecatchapp.ui.fragments.appintro.Pages.FirstScreen
import com.example.moviecatchapp.ui.fragments.appintro.Pages.FourthFragment
import com.example.moviecatchapp.ui.fragments.appintro.Pages.SecondScreen
import com.example.moviecatchapp.ui.fragments.appintro.Pages.ThirdhFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppintroFragment : Fragment() {

    private var _binding: FragmentAppintroBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAppintroBinding.inflate(inflater, container, false)
        val view = binding.root

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdhFragment(),
            FourthFragment(),
            FifthFragment()
        )

        val adapter = ViewPagerAdapter(fragmentList,requireActivity().supportFragmentManager,lifecycle)

        binding.viewpager.adapter = adapter

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}