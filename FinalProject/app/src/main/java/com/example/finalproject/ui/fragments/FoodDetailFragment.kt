package com.example.finalproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentFoodDetailBinding

class FoodDetailFragment : Fragment() {

    private lateinit var binding: FragmentFoodDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFoodDetailBinding.inflate(inflater, container, false)


        return binding.root
    }

}