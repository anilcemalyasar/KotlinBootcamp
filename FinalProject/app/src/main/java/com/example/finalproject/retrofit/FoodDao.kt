package com.example.finalproject.retrofit

import com.example.finalproject.data.entity.CRUDResult
import com.example.finalproject.data.entity.FoodResult
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodDao {

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun yemekleriYukle() : FoodResult

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun yemekEkle(@Field("yemek_adi")       yemek_adi: String,
                          @Field("yemek_resim_adi") yemek_resim_adi: String,
                          @Field("yemek_fiyat") yemek_fiyat: Int,
                          @Field("yemek_siparis_adet") yemek_siparis_adet: Int,
                          @Field("kullanici_adi") kullanici_adi: String) : CRUDResult


    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    suspend fun sil(@Field("sepet_yemek_id") sepet_yemek_id: String,
                    @Field("kullanici_adi") kullanici_adi: String) : CRUDResult
}