package com.example.kisileruygulamasi.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.databinding.FragmentKisiDetayBinding
import com.example.kisileruygulamasi.databinding.FragmentMainPageBinding
import com.example.kisileruygulamasi.ui.fragment.KisiDetayFragmentArgs
import com.example.kisileruygulamasi.ui.viewmodel.KisiDetayViewModel

class KisiDetayFragment : Fragment() {

    private lateinit var binding: FragmentKisiDetayBinding
    private lateinit var viewModel: KisiDetayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKisiDetayBinding.inflate(inflater, container, false)

        val bundle : KisiDetayFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi

        binding.editTextKisiAd.setText(gelenKisi.kisi_ad)
        binding.editTextKisiTel.setText(gelenKisi.kisi_tel)

        binding.buttonGuncelle.setOnClickListener {
            val kisi_adi = binding.editTextKisiAd.text.toString()
            val kisi_tel = binding.editTextKisiTel.text.toString()

            viewModel.guncelle(gelenKisi.kisi_id, kisi_adi, kisi_tel)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : KisiDetayViewModel by viewModels()
        viewModel = tempViewModel
    }


}