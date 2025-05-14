package com.example.kisileruygulamasi.data.datasource

import android.util.Log
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.room.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource(var kisilerDao: KisilerDao) {
    suspend fun kaydet(kisi_ad: String,kisi_tel: String){
//        Log.e("Kişi Kaydet","$kisi_ad - $kisi_tel")
        val yeniKisi = Kisiler(0, kisi_ad, kisi_tel)
        kisilerDao.kaydet(yeniKisi)
    }

    suspend fun guncelle(kisi_id:Int,kisi_ad: String,kisi_tel: String){
//        Log.e("Kişi Güncelle","$kisi_id - $kisi_ad - $kisi_tel")
        val guncellenenKisiler = Kisiler(kisi_id, kisi_ad, kisi_tel)
        kisilerDao.guncelle(guncellenenKisiler)
    }

    suspend fun sil(kisi_id:Int){
//        Log.e("Kişi Sil",kisi_id.toString())
        val kisi = Kisiler(kisi_id, "ece", "1111")
        kisilerDao.kayitSil(kisi)
    }

    suspend fun kayitKontrol(kisi_ad: String) {
        val sonuc = kisilerDao.kayitKontrol(kisi_ad)
        Log.e("İsmi ${kisi_ad} olan kişi sayısı", sonuc.toString())
    }

    suspend fun kisileriYukle() : List<Kisiler> = withContext(Dispatchers.IO) {
        return@withContext kisilerDao.kisileriYukle()
//        val liste = ArrayList<Kisiler>()
//        val k1 = Kisiler(1,"Ahmet","1111")
//        val k2 = Kisiler(2,"Zeynep","2222")
//        val k3 = Kisiler(3,"Beyza","3333")
//        liste.add(k1)
//        liste.add(k2)
//        liste.add(k3)
//
//        return@withContext  liste
    }

    suspend fun ara(aramaKelimesi:String) : List<Kisiler> = withContext(Dispatchers.IO) {
        val liste : List<Kisiler> = kisilerDao.kisiArama(aramaKelimesi)
        return@withContext liste
//        val liste = ArrayList<Kisiler>()
//        val k1 = Kisiler(1,"Ahmet","1111")
//        liste.add(k1)
//
//        return@withContext  liste
    }
}