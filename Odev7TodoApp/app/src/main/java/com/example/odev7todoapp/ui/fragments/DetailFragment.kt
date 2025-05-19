package com.example.odev7todoapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.odev7todoapp.R
import com.example.odev7todoapp.databinding.FragmentDetailBinding
import com.example.odev7todoapp.ui.viewmodel.DetailViewModel
import com.example.odev7todoapp.ui.viewmodel.MainPageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel

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

        binding.buttonUpdate.setOnClickListener {
            binding.editTextTodoId.setText(incomingTodo.id.toString())
            binding.editInputTodoName.setText(incomingTodo.name)
            binding.editTextTodoStart.setText(incomingTodo.startDate)
            binding.editInputTodoEnd.setText(incomingTodo.endDate)

//            viewModel.updateTodo(binding.editTextTodoId.text.toString().toInt(),
//                                 binding.editTextTodoStart.text = )
        }
        return binding.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetailViewModel by viewModels()
        viewModel = tempViewModel
    }

}