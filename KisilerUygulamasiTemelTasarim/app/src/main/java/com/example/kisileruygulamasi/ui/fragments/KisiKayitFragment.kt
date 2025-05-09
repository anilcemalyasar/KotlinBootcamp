package com.example.kisileruygulamasi.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.databinding.FragmentKisiKayitBinding

class KisiKayitFragment : Fragment() {

    private lateinit var binding: FragmentKisiKayitBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKisiKayitBinding.inflate(inflater, container, false)

        binding.buttonKaydet.setOnClickListener {
            val kisi_ad : String = binding.editTextKisiAd.text.toString()
            val kisi_tel : String = binding.editTextKisiTel.text.toString()

            kaydet(kisi_ad, kisi_tel)
        }
        return binding.root
    }

    fun kaydet(kisi_ad: String, kisi_tel: String) {
        Log.e("Kişi kaydet", "$kisi_ad - $kisi_tel")
    }

}