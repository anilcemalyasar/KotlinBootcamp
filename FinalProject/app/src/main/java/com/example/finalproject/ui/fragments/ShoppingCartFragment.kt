package com.example.finalproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentShoppingCartBinding
import com.example.finalproject.ui.adapter.ShoppingCartAdapter
import com.example.finalproject.ui.viewmodel.ShoppingCartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShoppingCartFragment : Fragment() {

    private lateinit var binding: FragmentShoppingCartBinding
    private lateinit var viewModel: ShoppingCartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShoppingCartBinding.inflate(inflater, container, false)

        viewModel.shoppingCartFoodList.observe(viewLifecycleOwner) {
            val foodCartAdapter = ShoppingCartAdapter(requireContext(), it, viewModel)
            binding.rvShoppingCartItems.adapter = foodCartAdapter
        }

        binding.rvShoppingCartItems.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : ShoppingCartViewModel by viewModels()
        viewModel = tempViewModel
    }
}