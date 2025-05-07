package com.example.odev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.odev4.databinding.FragmentMainPageBinding

class MainPageFragment : Fragment() {

    private lateinit var binding: FragmentMainPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainPageBinding.inflate(inflater, container, false)

        binding.buttonToPageA.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.gecisA)
        }

        binding.buttonToPageX.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.gecisX)
        }
        return binding.root
    }

}