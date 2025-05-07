package com.example.kisileruygulamasi.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.data.entity.Kisi
import com.example.kisileruygulamasi.databinding.FragmentMainPageBinding

class MainPageFragment : Fragment() {

    private lateinit var binding: FragmentMainPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainPageBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
        }

        binding.buttonDetay.setOnClickListener {
            val kisi1 = Kisi(1, "Ahmet", "1111")
            val gecis = MainPageFragmentDirections.kisiDetayGecis(kisi = kisi1)
            Navigation.findNavController(it).navigate(gecis)
        }
        return binding.root
    }

}