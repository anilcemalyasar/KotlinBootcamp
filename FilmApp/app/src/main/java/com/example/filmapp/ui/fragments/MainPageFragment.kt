package com.example.filmapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmapp.R
import com.example.filmapp.data.entity.Film
import com.example.filmapp.databinding.FragmentMainPageBinding
import com.example.filmapp.ui.adapter.FilmAdapter

class MainPageFragment : Fragment() {

    private lateinit var binding: FragmentMainPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainPageBinding.inflate(inflater, container, false)

        val filmsList = ArrayList<Film>()
        filmsList.add(Film(1, "Django", "django.png", 24))
        filmsList.add(Film(2, "Interstellar", "interstellar.png", 32))
        filmsList.add(Film(3, "Inception", "inception.png", 16))

        val filmAdapter = FilmAdapter(requireContext(), filmsList)
        binding.filmsRv.adapter = filmAdapter

        // horizontal olarak her satıra 2 card
        binding.filmsRv.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)

        return binding.root
    }

}