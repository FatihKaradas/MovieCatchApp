package com.example.moviecatchapp.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviecatchapp.R
import com.example.moviecatchapp.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment: Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root

        setupTabBar()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun setupTabBar(){
        binding.bottomNavBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> childFragmentManager.primaryNavigationFragment?.findNavController()?.navigate(R.id.homeFragment)
                R.id.nav_favorites -> childFragmentManager.primaryNavigationFragment?.findNavController()?.navigate(R.id.favoriteFragment)
                R.id.nav_settings -> childFragmentManager.primaryNavigationFragment?.findNavController()?.navigate(R.id.settingsFragment)
            }
            true
        }

    }
}