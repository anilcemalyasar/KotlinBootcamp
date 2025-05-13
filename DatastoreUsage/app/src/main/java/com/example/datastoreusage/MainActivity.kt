package com.example.datastoreusage

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.datastoreusage.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val appPref = AppPref(this)
//        appPref.kayit(10) Suspend bir fonksiyon olduğu için kullanamıyoruz
        CoroutineScope(Dispatchers.Main).launch {
            var gelenSayac = appPref.read()
            appPref.kayit(++gelenSayac)

            binding.textViewSayac.text = "Açılış Sayısı : ${gelenSayac}"
        }


    }
}