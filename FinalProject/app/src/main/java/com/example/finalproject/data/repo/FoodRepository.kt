package com.example.finalproject.data.repo

import com.example.finalproject.data.datasource.FoodDataSource
import com.example.finalproject.data.entity.CRUDResult
import com.example.finalproject.data.entity.Food
import com.example.finalproject.data.entity.ShoppingCartFood

class FoodRepository(var foodDataSource: FoodDataSource) {

    suspend fun yemekEkle(yemek_adi: String,
                          yemek_resim_adi: String,
                          yemek_fiyat: Int,
                          yemek_siparis_adet: Int,
                          kullanici_adi: String) = foodDataSource.yemekEkle(yemek_adi,
                                                                            yemek_resim_adi,
                                                                            yemek_fiyat,
                                                                            yemek_siparis_adet,
                                                                            kullanici_adi)

    suspend fun yemekleriYukle() : List<Food> = foodDataSource.yemekleriYukle()

    suspend fun sepettekiYemekleriGetir(kullanici_adi: String) : List<ShoppingCartFood>
                                                        = foodDataSource.sepettekiYemekleriGetir(kullanici_adi)

    suspend fun sepettenYemekSil(sepet_yemek_id: Int, kullanici_adi: String)
                                                        = foodDataSource.sepettenYemekSil(sepet_yemek_id, kullanici_adi)
}