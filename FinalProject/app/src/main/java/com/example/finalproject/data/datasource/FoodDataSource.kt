package com.example.finalproject.data.datasource

import android.util.Log
import com.example.finalproject.data.entity.Food
import com.example.finalproject.retrofit.FoodDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodDataSource(var foodDao: FoodDao) {

    suspend fun yemekEkle(yemek_adi: String,
                          yemek_resim_adi: String,
                          yemek_fiyat: Int,
                          yemek_siparis_adet: Int,
                          kullanici_adi: String) {
        val crudResult = foodDao.yemekEkle(yemek_adi, yemek_resim_adi, yemek_fiyat,
                                                yemek_siparis_adet, kullanici_adi)
        Log.e("Sepete Yemek Ekleme", "Success : ${crudResult.success} - Message : ${crudResult.message}")
    }

    suspend fun yemekleriYukle() : List<Food> = withContext(Dispatchers.IO) {
        return@withContext foodDao.yemekleriYukle().yemekler
    }


}