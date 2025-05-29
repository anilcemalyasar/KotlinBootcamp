package com.example.finalproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentMainPageBinding
import com.example.finalproject.ui.adapter.FoodAdapter
import com.example.finalproject.ui.viewmodel.MainPageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainPageFragment : Fragment() {

    private lateinit var binding: FragmentMainPageBinding
    private lateinit var viewModel: MainPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainPageBinding.inflate(inflater, container, false)

        viewModel.foodList.observe(viewLifecycleOwner) {
            val foodAdapter = FoodAdapter(requireContext(), it, viewModel)
            binding.foodsRv.adapter = foodAdapter
        }

        binding.foodsRv.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        // Search View Android Widget olanı kullanacağız
//        binding.searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener{
//            override fun onQueryTextChange(newText: String): Boolean {//Harf girdikçe ve sildikçe
//                viewModel.ara(newText)
//                return true
//            }
//
//            override fun onQueryTextSubmit(query: String): Boolean {//Ara buttonuna basılınca
//                viewModel.ara(query)
//                return true
//            }
//        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainPageViewModel by viewModels()
        viewModel = tempViewModel
    }

//    override fun onResume() {
//        super.onResume()
//        viewModel.yemekleriYukle()
//    }

}