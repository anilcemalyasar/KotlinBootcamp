package com.example.navigationcomponentusage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.navigationcomponentusage.databinding.FragmentMainPageBinding

class MainPageFragment : Fragment() {

    private lateinit var binding: FragmentMainPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainPageBinding.inflate(inflater, container, false)
        binding.buttonDetay.setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.detayGecis)
            val gecis = MainPageFragmentDirections.detayGecis(message = "Nasılsın", number = 99)
            it.findNavController().navigate(gecis)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // uygulamayı çalıştırdığımızda 1 kere çalışır
        Log.e("Lifecycle", "onCreate method is worked")
    }

    override fun onResume() {
        super.onResume()
        // sayfa her göründüğünde çalışır
        // bu sayfaya geri dönüldüğünde çalışır
        Log.e("Lifecycle", "onResume method is worked")
    }

    override fun onPause() {
        super.onPause()
        // sayfa her görünmez olduğunda çalışır
        Log.e("Lifecycle", "onPause method is worked")
    }

}