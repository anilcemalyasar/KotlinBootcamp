package com.example.odev7todoapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.odev7todoapp.R
import com.example.odev7todoapp.databinding.FragmentKayitBinding

class KayitFragment : Fragment() {

    private lateinit var binding: FragmentKayitBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKayitBinding.inflate(inflater, container, false)
        return binding.root
    }

}