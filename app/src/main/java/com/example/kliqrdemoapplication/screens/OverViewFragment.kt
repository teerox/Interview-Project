package com.example.kliqrdemoapplication.screens

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.kliqrdemoapplication.R
import com.example.kliqrdemoapplication.databinding.FragmentOverViewBinding



/**
 * A simple [Fragment] subclass.
 */
class OverViewFragment : Fragment() {

    lateinit var binding: FragmentOverViewBinding
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_over_view,container,false)

        (activity as MainActivity).supportActionBar?.title = getString(R.string.overview)
        binding.scrollView.setOnTouchListener { _, _ ->
            binding.scrollView.parent.requestDisallowInterceptTouchEvent(true)
            false
        }

        return binding.root
    }

}
