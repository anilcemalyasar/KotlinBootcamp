package com.example.datastoreusage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class AppPref(var context: Context) {

    // Key - Value ilişkisi ile basit verileri kalıcı olarak depolayabiliriz.
    val Context.ds : DataStore<Preferences> by preferencesDataStore("bilgiler")

    // static fields
    companion object {
        val SAYAC_KEY = intPreferencesKey("SAYAC")


    }

    // coroutine
    suspend fun kayit(sayac: Int) {
        context.ds.edit {
            it[SAYAC_KEY] = sayac
        }
    }

    suspend fun read() : Int {
        val p = context.ds.data.first()
        return p[SAYAC_KEY] ?: 0 // eğer bu keyde bir integer değer yoksa default olarak 99 döner
    }

    suspend fun sil() {
        context.ds.edit {
            it.remove(SAYAC_KEY)
        }
    }
}