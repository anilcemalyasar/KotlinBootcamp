package com.example.widgetsusage

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.widgetsusage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var check = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toggleButton.addOnButtonCheckedListener { group, checkedId, isChecked ->
            check = isChecked
            if (check) {
                val selectedButton = findViewById<Button>(checkedId)
                val buttonText = selectedButton.text.toString()
                Log.e("Result", buttonText)
            }
        }

        binding.buttonShow.setOnClickListener {
            if (check) {
                val selectedButton = findViewById<Button>(binding.toggleButton.checkedButtonId)
                val buttonText = selectedButton.text.toString()
                Log.e("Result ( Show )", buttonText)
            }
        }
    }
}