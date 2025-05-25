package com.example.finalproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.finalproject.data.repo.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingCartViewModel @Inject constructor(var foodRepository: FoodRepository) : ViewModel() {

    fun sepettekiYemekleriGetir(kullanici_adi: String) {
        CoroutineScope(Dispatchers.Main).launch {
            foodRepository.sepettekiYemekleriGetir(kullanici_adi)
        }
    }
}