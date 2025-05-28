package com.example.finalproject.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalproject.data.entity.Food
import com.example.finalproject.databinding.CardDesignBinding
import com.example.finalproject.ui.fragments.MainPageFragmentDirections
import com.example.finalproject.ui.viewmodel.MainPageViewModel

class FoodAdapter(var mContext: Context,
                  var foodList: List<Food>,
                  var viewModel: MainPageViewModel)
    : RecyclerView.Adapter<FoodAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var design: CardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardDesignBinding.inflate(layoutInflater, parent, false)
        return CardDesignHolder(tasarim)
    }

    override fun onBindViewHolder(
        holder: CardDesignHolder,
        position: Int
    ) {
        val food = foodList.get(position)
        val t = holder.design
        t.foodName.text = food.yemek_adi
        t.foodPrice.text = "₺ ${food.yemek_fiyat}"

        // URL oluştur
        val imageUrl = "http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}"

        // Glide ile resmi yükle
        Glide.with(mContext)
            .load(imageUrl)
            .into(t.foodImage)

        t.cardViewRow.setOnClickListener {
            val gecis = MainPageFragmentDirections.detayGecis(food)
            Navigation.findNavController(it).navigate(gecis)

        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}
