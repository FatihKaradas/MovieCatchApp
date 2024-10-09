package com.example.moviecatchapp.ui.fragments.appintro.Pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.moviecatchapp.R
import com.example.moviecatchapp.databinding.FragmentFifthBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FifthFragment: Fragment() {
    private var _binding: FragmentFifthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFifthBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onResume() {
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewpager)
        val prevbutton = activity?.findViewById<RelativeLayout>(R.id.prevButton)
        val nextbutton = activity?.findViewById<RelativeLayout>(R.id.nxtButton)

        nextbutton?.alpha = 0f
        nextbutton?.isClickable = false

        prevbutton?.setOnClickListener{
            viewPager?.currentItem = 3
        }

        super.onResume()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}