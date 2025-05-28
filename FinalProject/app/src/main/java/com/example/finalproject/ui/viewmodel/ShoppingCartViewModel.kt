package com.example.finalproject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.data.entity.ShoppingCartFood
import com.example.finalproject.data.repo.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingCartViewModel @Inject constructor(var foodRepository: FoodRepository) : ViewModel() {

    var shoppingCartFoodList = MutableLiveData<List<ShoppingCartFood>>()

    init {
        sepettekiYemekleriGetir(kullanici_adi = "anil_cemal_yasar_deneme")
    }

    fun sepettekiYemekleriGetir(kullanici_adi: String = "anil_cemal_yasar_deneme") {
        CoroutineScope(Dispatchers.Main).launch {
            shoppingCartFoodList.value = foodRepository.sepettekiYemekleriGetir(kullanici_adi)
        }
    }

    fun sepettenYemekSilme(sepet_yemek_id: Int, kullanici_adi: String = "anil_cemal_yasar_deneme") {
        CoroutineScope(Dispatchers.Main).launch {
            if (shoppingCartFoodList.value.size > 1) {
                foodRepository.sepettenYemekSil(sepet_yemek_id, kullanici_adi)
                shoppingCartFoodList.value = foodRepository.sepettekiYemekleriGetir(kullanici_adi)
            } else {
                foodRepository.sepettenYemekSil(sepet_yemek_id, kullanici_adi)
                shoppingCartFoodList.value = ArrayList<ShoppingCartFood>()
            }
        }
    }
}