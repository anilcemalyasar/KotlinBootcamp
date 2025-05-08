package com.example.kisileruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasi.data.entity.Kisi
import com.example.kisileruygulamasi.databinding.CardTasarimBinding
import com.example.kisileruygulamasi.ui.fragments.MainPageFragmentDirections
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var mContext: Context, var kisilerListesi: List<Kisi>)
    : RecyclerView.Adapter<KisilerAdapter.CardDesignHolder>(){

    // bu sınıf kart tasarımını temsil ediyor
    inner class CardDesignHolder(var design: CardTasarimBinding) : RecyclerView.ViewHolder(design.root) {


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardDesignHolder {
        val tasarim = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(tasarim)
    }

    // kartların sayısı kaçsa bu fonksiyon döngü gibi o kadar çalışıyor
    override fun onBindViewHolder(
        holder: CardDesignHolder,
        position: Int
    ) {
        val kisi : Kisi = kisilerListesi.get(position) // 0, 1, 2
        val t = holder.design
        t.textViewKisiAdi.text = kisi.kisi_ad
        t.textViewKisiTel.text = kisi.kisi_tel

        t.cardViewRow.setOnClickListener {
            val gecis = MainPageFragmentDirections.kisiDetayGecis(kisi = kisi)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.imageViewCancel.setOnClickListener {
            Snackbar.make(it, "${kisi.kisi_ad} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("EVET") {
                    sil(kisi.kisi_id)
                }.show()
        }
    }

    // kaç kart listeleneceğini belirlediğimiz fonksiyon
    override fun getItemCount(): Int {
        return kisilerListesi.size
    }

    fun sil(kisi_id: Int) {
        Log.e("Kişi Sil", kisi_id.toString())
    }
}