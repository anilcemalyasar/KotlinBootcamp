package com.example.finalproject.ui.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalproject.data.entity.Food
import com.example.finalproject.data.entity.ShoppingCartFood
import com.example.finalproject.databinding.ShoppingItemCardDesignBinding
import com.example.finalproject.ui.viewmodel.ShoppingCartViewModel
import com.google.android.material.snackbar.Snackbar

class ShoppingCartAdapter(var mContext: Context,
                          var shoppingCartFoodList: List<ShoppingCartFood>,
                          var viewModel: ShoppingCartViewModel)
    : RecyclerView.Adapter<ShoppingCartAdapter.ShoppingCartDesignHolder>() {

    inner class ShoppingCartDesignHolder(var design: ShoppingItemCardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShoppingCartDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = ShoppingItemCardDesignBinding.inflate(layoutInflater, parent, false)
        return ShoppingCartDesignHolder(tasarim)
    }

    override fun onBindViewHolder(
        holder: ShoppingCartDesignHolder,
        position: Int
    ) {
        val food = shoppingCartFoodList.get(position)
        val t = holder.design
        if (food != null) {
            // image url olusturarak ürün görselini Glide ile çekeceğiz
            val imageUrl = "http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}"
            Glide.with(mContext)
                .load(imageUrl)
                .into(t.ivShoppingCartFoodImage)

            t.tvShoppingCartFoodName.text = food.yemek_adi
            t.tvShoppingCartFoodPrice.text = "Fiyat: \t  ₺ ${food.yemek_fiyat}"
            t.tvShoppingCartFoodQuantity.text = "Adet: \t  ₺ ${food.yemek_siparis_adet}"

            var totalItemPrice : Int = food.yemek_fiyat.toInt() * food.yemek_siparis_adet.toInt()
            t.tvShoppingCartFoodTotal.text = "₺ ${totalItemPrice}"

            t.icDelete.setOnClickListener { view ->
                Snackbar.make(view, "${food.yemek_adi} sepetten silinsin mi?", Snackbar.LENGTH_LONG)
                    .setAction("Evet") {
                        viewModel.sepettenYemekSilme(food.sepet_yemek_id)
                        Snackbar.make(view, "${food.yemek_adi} sepetten başarıyla silindi.",
                            Snackbar.LENGTH_SHORT)
                            .setBackgroundTint(Color.WHITE)
                            .setTextColor(Color.BLACK)
                            .show()
                    }
                    .setBackgroundTint(Color.WHITE)
                    .setTextColor(Color.BLACK)
                    .setActionTextColor(Color.RED)
                    .show()
            }

        }

    }

    override fun getItemCount(): Int {
        return shoppingCartFoodList.size
    }
}
