package com.example.odev7todoapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.odev7todoapp.R
import com.example.odev7todoapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        val bundle: DetailFragmentArgs by navArgs()
        val incomingTodo = bundle.todo

        binding.editTextTodoId.setText(incomingTodo.id.toString())
        binding.editInputTodoName.setText(incomingTodo.name)
        binding.editTextTodoStart.setText(incomingTodo.startDate)
        binding.editInputTodoEnd.setText(incomingTodo.endDate)
        return binding.root
    }

}