package com.example.kisileruygulamasi.data.datasource

import android.util.Log
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.retrofit.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource(var kisilerDao: KisilerDao) {
    suspend fun kaydet(kisi_ad: String,kisi_tel: String){
//        Log.e("Kişi Kaydet","$kisi_ad - $kisi_tel")
        val crudCevap = kisilerDao.kaydet(kisi_ad,kisi_tel)
        Log.e("Kişi Kaydet","Success : ${crudCevap.success} - Message : ${crudCevap.message}")
    }

    suspend fun guncelle(kisi_id:Int,kisi_ad: String,kisi_tel: String){
//        Log.e("Kişi Güncelle","$kisi_id - $kisi_ad - $kisi_tel")
//        val guncellenenKisiler = Kisiler(kisi_id, kisi_ad, kisi_tel)
        val crudCevap = kisilerDao.guncelle(kisi_id,kisi_ad,kisi_tel)
        Log.e("Kişi Güncelle","Success : ${crudCevap.success} - Message : ${crudCevap.message}")
    }

    suspend fun sil(kisi_id:Int){
        val crudCevap = kisilerDao.sil(kisi_id)
        Log.e("Kişi Sil","Success : ${crudCevap.success} - Message : ${crudCevap.message}")
    }

//    suspend fun kayitKontrol(kisi_ad: String) {
//        val sonuc = kisilerDao.kayitKontrol(kisi_ad)
//        Log.e("İsmi ${kisi_ad} olan kişi sayısı", sonuc.toString())
//    }

    suspend fun kisileriYukle() : List<Kisiler> = withContext(Dispatchers.IO) {
        return@withContext kisilerDao.kisileriYukle().kisiler
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
        return@withContext kisilerDao.ara(aramaKelimesi).kisiler
//        val liste = ArrayList<Kisiler>()
//        val k1 = Kisiler(1,"Ahmet","1111")
//        liste.add(k1)
//
//        return@withContext  liste
    }
}