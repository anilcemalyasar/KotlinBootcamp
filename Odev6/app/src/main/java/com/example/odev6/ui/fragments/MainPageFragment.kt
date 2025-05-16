package com.example.odev6.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.odev6.R
import com.example.odev6.data.entity.Product
import com.example.odev6.databinding.FragmentMainPageBinding
import com.example.odev6.ui.adapter.ProductAdapter

class MainPageFragment : Fragment() {

    private lateinit var binding: FragmentMainPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainPageBinding.inflate(inflater, container, false)

        val productList = ArrayList<Product>()
        productList.add(Product(1, "MacBook Air M4", 45.999, 16, 256, 5.0, 574, "macbook_air_m4"))
        productList.add(Product(2, "MacBook Air M3", 32.999, 16, 256, 4.3, 289, "macbook_air_m4"))

        val productAdapter = ProductAdapter(requireContext(), productList)
        binding.rvProducts.adapter = productAdapter

        // horizontal olarak her satıra 2 card
        binding.rvProducts.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        return binding.root
    }

}