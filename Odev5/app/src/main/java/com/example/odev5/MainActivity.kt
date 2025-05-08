package com.example.odev5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odev5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.buttonTopla.setOnClickListener {

            if (!binding.editTextNumber.text.isEmpty()) {
                val enteredNumber : Int = binding.editTextNumber.text.toString().toInt()
                val prevResult = binding.textViewResult.text.toString().toInt()
                val currentResult : String = (enteredNumber + prevResult).toString()
                binding.textViewResult.text = currentResult
            }
        }

        binding.buttonSifirla.setOnClickListener {
            binding.textViewResult.text = "0"
        }

        setContentView(binding.root)

    }
}