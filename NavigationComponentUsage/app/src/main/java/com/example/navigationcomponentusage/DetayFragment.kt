package com.example.navigationcomponentusage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponentusage.databinding.FragmentDetayBinding

class DetayFragment : Fragment() {

    private lateinit var binding: FragmentDetayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetayBinding.inflate(inflater, container, false)

        // veri alan sınıfın sonuna args geliyor, veri almayı bundle objesiyle yapıyoruz
        val bundle: DetayFragmentArgs by navArgs()
        val incomingMessage = bundle.message
        val incomingNumber = bundle.number

        binding.textViewResult.text = "$incomingMessage - $incomingNumber"

        val backButton = object : OnBackPressedCallback(enabled = true) { // true geri dönüş aktif değil
            override fun handleOnBackPressed() {
                Log.e("Detay Sayfa", "Back button worked")
                isEnabled = false
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, backButton)
        return binding.root
    }

}