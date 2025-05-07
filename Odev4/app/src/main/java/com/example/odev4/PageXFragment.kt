package com.example.odev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.odev4.databinding.FragmentPageXBinding

class PageXFragment : Fragment() {

    private lateinit var binding: FragmentPageXBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPageXBinding.inflate(inflater, container, false)
        return binding.root
    }



}