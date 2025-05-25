package com.example.finalproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.finalproject.data.repo.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodDetailViewModel @Inject constructor(var foodRepository: FoodRepository) : ViewModel() {

    fun sepeteYemekEkle(yemek_adi: String,
                        yemek_resim_adi: String,
                        yemek_fiyat: Int,
                        yemek_siparis_adet: Int,
                        kullanici_adi: String) {
        CoroutineScope(Dispatchers.Main).launch {
            foodRepository.yemekEkle(yemek_adi,
                                     yemek_resim_adi,
                                     yemek_fiyat,
                                     yemek_siparis_adet,
                                     kullanici_adi)
        }
    }
}