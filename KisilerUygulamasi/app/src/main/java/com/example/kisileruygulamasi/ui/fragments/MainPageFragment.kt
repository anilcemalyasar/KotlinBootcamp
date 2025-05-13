package com.example.kisileruygulamasi.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.data.entity.Kisi
import com.example.kisileruygulamasi.databinding.FragmentMainPageBinding
import com.example.kisileruygulamasi.ui.adapter.KisilerAdapter
import com.example.kisileruygulamasi.ui.viewmodel.MainPageViewModel
import com.example.kisileruygulamasi.utils.gecisYap

class MainPageFragment : Fragment() {

    private lateinit var binding: FragmentMainPageBinding
    private lateinit var viewModel: MainPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainPageBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
            Navigation.gecisYap(it, R.id.kisiKayitGecis)
        }

//        val kisilerListesi = ArrayList<Kisi>()
//        kisilerListesi.add(Kisi(1, "Ahmet", "1111"))
//        kisilerListesi.add(Kisi(2, "Beyza", "2222"))
//        kisilerListesi.add(Kisi(3, "Zeynep", "2222"))

        viewModel.kisilerListesi.observe(viewLifecycleOwner) {  // verileri dinleme
            val kisilerAdapter = KisilerAdapter(requireContext(), it, viewModel)
            binding.kisilerRv.adapter = kisilerAdapter
        }


        // vertical olarak sıralıyor kartları
        binding.kisilerRv.layoutManager = LinearLayoutManager(requireContext())

        // 2 parametresi spanCount, bir satıra kaç kart yerleşeceği
//        binding.kisilerRv.layoutManager =
//                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)



        // Search View Android Widget olanı kullanacağız
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean { // harf girdikçe ve sildikçe çalışacak
                viewModel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean { // ara butonuna basılınca çalışacak
                viewModel.ara(query)
                return true
            }
        })

//        binding.buttonDetay.setOnClickListener {
//            val kisi1 = Kisi(1, "Ahmet", "1111")
//            val gecis = MainPageFragmentDirections.kisiDetayGecis(kisi = kisi1)
//            Navigation.findNavController(it).navigate(gecis)
//        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : MainPageViewModel by viewModels()
        viewModel = tempViewModel
    }

//    fun ara(aramaKelimesi: String) {
//        Log.e("Kişi Ara", aramaKelimesi)
//    }

    // sayfaya geri dönünce verileri fetch ediyoruz tekrardan
    override fun onResume() {
        super.onResume()
        viewModel.kisileriYukle()
    }

}