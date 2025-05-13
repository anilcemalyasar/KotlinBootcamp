package com.example.filmapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.filmapp.R
import com.example.filmapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        val bundle : DetailFragmentArgs by navArgs()
        val incomingFilm = bundle.film

        binding.toolbar.title = incomingFilm.name
        binding.tvPrice.text = "${incomingFilm.price} ₺"

        binding.ivFilm.setImageResource(
            resources.getIdentifier(incomingFilm.image, "drawable", requireContext().packageName)
        )
        return binding.root
    }

}