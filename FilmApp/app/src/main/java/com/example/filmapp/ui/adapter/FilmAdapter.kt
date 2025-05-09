package com.example.filmapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.filmapp.data.entity.Film
import com.example.filmapp.databinding.CardDesignBinding
import com.example.filmapp.ui.fragments.MainPageFragmentDirections
import com.google.android.material.snackbar.Snackbar

class FilmAdapter(var mContext: Context, var filmsList : List<Film>):
        RecyclerView.Adapter<FilmAdapter.CardDesignHolder>(){

    inner class CardDesignHolder(var design : CardDesignBinding) : RecyclerView.ViewHolder(design.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardDesignHolder {
        val tasarim = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(tasarim)
    }

    // kartların sayısı kaçsa bu fonksiyon döngü gibi o kadar çalışıyor
    override fun onBindViewHolder(
        holder: CardDesignHolder,
        position: Int
    ) {
        val film : Film  = filmsList.get(position) // 0 1 2
        val t = holder.design
        t.imageView.setImageResource(
            mContext.resources.getIdentifier(film.image, "drawable", mContext.packageName)
        )

        t.textViewPrice.text = "24"
//        t.textViewPrice.text = "${film.price} ₺"
        t.cardViewRow.setOnClickListener {
            val gecis = MainPageFragmentDirections.detailGecis(film = film)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.buttonCart.setOnClickListener {
            Snackbar.make(it, "${film.name} sepete eklendi", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return filmsList.size
    }
}