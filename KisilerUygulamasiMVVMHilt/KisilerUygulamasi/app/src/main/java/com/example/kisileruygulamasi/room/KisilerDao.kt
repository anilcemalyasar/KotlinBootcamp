package com.example.kisileruygulamasi.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kisileruygulamasi.data.entity.Kisiler

@Dao
interface KisilerDao {

    @Query("SELECT * FROM kisiler")
    suspend fun kisileriYukle() : List<Kisiler>

    @Insert
    suspend fun kaydet(kisi: Kisiler)

    @Update
    suspend fun guncelle(kisi: Kisiler)

    @Delete
    suspend fun kayitSil(kisi: Kisiler)

    @Query("SELECT COUNT(*) FROM kisiler WHERE kisi_ad=:kisi_ad")
    suspend fun kayitKontrol(kisi_ad: String) : Int

    @Query("SELECT * FROM kisiler WHERE kisi_ad LIKE '%' || :kisi_ad || '%'")
    suspend fun kisiArama(kisi_ad: String) : List<Kisiler>
}