package com.example.odev7todoapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.odev7todoapp.R
import com.example.odev7todoapp.databinding.FragmentKayitBinding
import com.example.odev7todoapp.ui.viewmodel.KayitViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.Locale
import kotlin.getValue

@AndroidEntryPoint
class KayitFragment : Fragment() {

    private lateinit var binding: FragmentKayitBinding
    private lateinit var viewModel: KayitViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKayitBinding.inflate(inflater, container, false)

        binding.buttonInsert.setOnClickListener {
            var start_date : String = binding.etInsertTodoStart.text.toString()
            var end_date : String = binding.etInsertTodoEnd.text.toString()
            val name : String = binding.etInsertTodoName.text.toString()

            start_date = tarihDonustur(start_date)
            end_date = tarihDonustur(end_date)

            viewModel.addTodo(name, start_date, end_date)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KayitViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun tarihDonustur(girdi: String): String {
        val girisFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val cikisFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val tarih = girisFormat.parse(girdi)
        return cikisFormat.format(tarih!!)
    }



}