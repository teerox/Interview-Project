package com.example.kliqrdemoapplication.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kliqrdemoapplication.R

/**
 * A simple [Fragment] subclass.
 */
class BudgetFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as MainActivity).supportActionBar?.title = getString(R.string.budget)
        return inflater.inflate(R.layout.fragment_budget, container, false)
    }

}
