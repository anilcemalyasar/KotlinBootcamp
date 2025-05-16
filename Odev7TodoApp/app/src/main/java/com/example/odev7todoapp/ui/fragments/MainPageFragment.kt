package com.example.odev7todoapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.odev7todoapp.R
import com.example.odev7todoapp.data.entity.Todo
import com.example.odev7todoapp.databinding.FragmentMainPageBinding
import com.example.odev7todoapp.ui.adapter.TodoAdapter

class MainPageFragment : Fragment() {

    private lateinit var binding: FragmentMainPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainPageBinding.inflate(inflater, container, false)

        binding.todosRv.layoutManager = LinearLayoutManager(requireContext())

        val todoList = ArrayList<Todo>()
        todoList.add(Todo(1, "Unity DB connection will be fixed", "16.05.2025", "21.05.2025"))
        todoList.add(Todo(2, "Addition to Articles fundamentals section", "16.05.2025", "22.05.2025"))

        val adapter = TodoAdapter(requireContext(), todoList)
        binding.todosRv.adapter = adapter
        return binding.root
    }
}