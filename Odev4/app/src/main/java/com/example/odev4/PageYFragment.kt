package com.example.odev4

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.odev4.databinding.FragmentPageYBinding
import com.google.android.material.snackbar.Snackbar

class PageYFragment : Fragment() {

    private lateinit var binding: FragmentPageYBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPageYBinding.inflate(inflater, container, false)


        val backPress = object : OnBackPressedCallback(enabled = true) {
            override fun handleOnBackPressed() {
                Log.e("Page Y", "Pressed on back button")
                isEnabled = false
//                Snackbar.make(binding.textView4, "Do you want to return back?", Snackbar.LENGTH_SHORT)
//                    .setAction("Yes") {
//                        isEnabled = false // geri dönüş aktif
//                        Log.e("Page Y", "Pressed on back button")
////                        requireActivity().onBackPressedDispatcher.onBackPressed() // geri dönüş kodu
//                    }.show()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, backPress)
        return binding.root
    }

}