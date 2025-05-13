package com.example.kisileruygulamasi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.entity.Kisi
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

// inheritance from view model
@HiltViewModel
class MainPageViewModel @Inject constructor(var kisilerRepository: KisilerRepository) : ViewModel() {

    var kisilerListesi = MutableLiveData<List<Kisi>>()

    init {
        kisileriYukle()
    }

    fun kisileriYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = kisilerRepository.kisileriYukle() // tetikleme
        }
    }

    fun sil(kisi_id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            kisilerRepository.sil(kisi_id)
            kisileriYukle()
        }
    }

    fun ara(aramaKelimesi: String) {
        CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = kisilerRepository.ara(aramaKelimesi)
        }
    }
}