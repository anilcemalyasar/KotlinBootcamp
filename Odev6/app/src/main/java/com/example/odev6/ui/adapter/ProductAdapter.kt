package com.example.odev6.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.odev6.data.entity.Product
import com.example.odev6.databinding.CardDesignBinding
import com.example.odev6.ui.fragments.MainPageFragmentDirections

class ProductAdapter(var mContext: Context, var productList: List<Product>)
    : RecyclerView.Adapter<ProductAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var design: CardDesignBinding) : RecyclerView.ViewHolder(design.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardDesignHolder {
        val tasarim = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(tasarim)
    }

    override fun onBindViewHolder(
        holder: CardDesignHolder,
        position: Int
    ) {

        val product : Product = productList.get(position)
        val t = holder.design

        t.ivCardProduct.setImageResource(
            mContext.resources.getIdentifier(product.image, "drawable", mContext.packageName)
        )

        t.tvCardProductName.text = product.name
        t.tvProductPrice.text = "${product.price} TL "
        t.cardViewProduct.setOnClickListener {
            val gecis = MainPageFragmentDirections.detailGecis(product = product)
            Navigation.findNavController(it).navigate(gecis)
        }

    }

    override fun getItemCount(): Int {
        return productList.size
    }
}