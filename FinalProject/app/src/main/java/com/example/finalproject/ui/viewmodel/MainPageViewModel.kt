package com.example.finalproject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.data.entity.Food
import com.example.finalproject.data.repo.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(var foodRepository: FoodRepository) : ViewModel() {

    var foodList = MutableLiveData<List<Food>>()

    init {
        yemekleriYukle()
    }

    fun yemekleriYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            foodList.value = foodRepository.yemekleriYukle()
        }
    }

    fun ara(aramaKelimesi: String) {
        CoroutineScope(Dispatchers.Main).launch {
            val allFoods : List<Food> = foodRepository.yemekleriYukle()
            val filteredFoods = allFoods.filter { food ->
                food.yemek_adi.contains(aramaKelimesi, ignoreCase = true)
            }
            foodList.value = filteredFoods
        }
    }
}