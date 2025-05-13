package com.example.kisileruygulamasi.data.datasource

import android.util.Log
import com.example.kisileruygulamasi.data.entity.Kisi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource {

    // suspend async mantığı gibi, multi threading db işlemlerinde
    suspend fun kaydet(kisi_ad: String, kisi_tel: String) {
        Log.e("Kişi kaydet", "$kisi_ad - $kisi_tel")
    }

    suspend fun guncelle(kisi_id: Int, kisi_ad: String, kisi_tel: String) {
        Log.e("Kişi Güncelle", "$kisi_id - $kisi_ad - $kisi_tel")
    }

    suspend fun sil(kisi_id: Int) {
        Log.e("Kişi Sil", kisi_id.toString())
    }

    // IO veri tabanına yakın olan kısımlarda kullandığımız
    suspend fun kisileriYukle() : List<Kisi> = withContext(Dispatchers.IO) {
        val liste = ArrayList<Kisi>()
        liste.add(Kisi(1, "Ahmet", "1111"))
        liste.add(Kisi(2, "Beyza", "2222"))
        liste.add(Kisi(3, "Zeynep", "3333"))

        return@withContext liste
    }

    // IO veri tabanına yakın olan kısımlarda kullandığımız
    suspend fun ara(aramaKelimesi: String) : List<Kisi> = withContext(Dispatchers.IO) {
        val liste = ArrayList<Kisi>()
        liste.add(Kisi(1, "Ahmet", "1111"))

        return@withContext liste
    }
}