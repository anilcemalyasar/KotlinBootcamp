package com.example.odev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.odev4.databinding.FragmentMainPageBinding
import com.example.odev4.databinding.FragmentPageBBinding

class PageBFragment : Fragment() {

    private lateinit var binding: FragmentPageBBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPageBBinding.inflate(inflater, container, false)

        binding.buttonToPageY.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.gecisFromBToY)
        }

        return binding.root
    }
}