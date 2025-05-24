package com.example.kisileruygulamasi.retrofit

import com.example.kisileruygulamasi.data.entity.CRUDResult
import com.example.kisileruygulamasi.data.entity.KisilerResult
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface KisilerDao {

    @GET("kisiler/tum_kisiler.php")
    suspend fun kisileriYukle() : KisilerResult

    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded
    suspend fun kaydet(@Field("kisi_ad") kisi_ad: String,
                       @Field("kisi_tel") kisi_tel: String) : CRUDResult

    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    suspend fun guncelle(@Field("kisi_id") kisi_id:Int,
                         @Field("kisi_ad") kisi_ad: String,
                         @Field("kisi_tel") kisi_tel: String) : CRUDResult

    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded
    suspend fun ara(@Field("kisi_ad") aramaKelimesi: String) : KisilerResult

    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded
    suspend fun sil(@Field("kisi_id") kisi_id: Int) : CRUDResult
}