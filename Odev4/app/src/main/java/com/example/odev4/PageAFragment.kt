package com.example.odev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.odev4.databinding.FragmentPageABinding

class PageAFragment : Fragment() {

    private lateinit var binding: FragmentPageABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPageABinding.inflate(inflater, container, false)

        binding.buttonToPageB.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.gecisB)
        }
        return binding.root
    }

}