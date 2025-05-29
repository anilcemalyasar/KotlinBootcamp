package com.example.finalproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentFoodDetailBinding
import com.example.finalproject.ui.viewmodel.FoodDetailViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.findNavController
import kotlin.random.Random

@AndroidEntryPoint
class FoodDetailFragment : Fragment() {

    private lateinit var binding: FragmentFoodDetailBinding
    private lateinit var viewModel: FoodDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFoodDetailBinding.inflate(inflater, container, false)

        val bundle : FoodDetailFragmentArgs by navArgs()
        val incomingFood = bundle.yemek

        // Puanını rastgele seçme
        val randomRating = (2..5).random() + listOf(0f, 0.5f).random()
        binding.ratingBar.rating = randomRating

        binding.tvFoodName.text = incomingFood.yemek_adi
        binding.tvFoodPrice.text = "₺ ${incomingFood.yemek_fiyat}"
        var totalFoodPrice : Int = incomingFood.yemek_fiyat * binding.tvFoodQuantity.text.toString().toInt()
        binding.tvDetailProductTotalPrice.text = "Toplam: ₺ ${totalFoodPrice}"

        binding.quantityIncreaseButton.setOnClickListener {
            binding.tvFoodQuantity.text = "${binding.tvFoodQuantity.text.toString().toInt() + 1}"
            totalFoodPrice = incomingFood.yemek_fiyat * binding.tvFoodQuantity.text.toString().toInt()
            binding.tvDetailProductTotalPrice.text = "Toplam: ₺ ${totalFoodPrice}"
        }

        binding.quantityDecreaseButton.setOnClickListener {
            if (binding.tvFoodQuantity.text.toString().toInt() > 0) {
                binding.tvFoodQuantity.text = "${binding.tvFoodQuantity.text.toString().toInt() - 1}"
                totalFoodPrice = incomingFood.yemek_fiyat * binding.tvFoodQuantity.text.toString().toInt()
                binding.tvDetailProductTotalPrice.text = "Toplam: ₺ ${totalFoodPrice}"
            } else {
                // burada sepette bu üründen hiç yok uyarısı geçmek lazım
            }
        }


        // URL oluştur
        val imageUrl = "http://kasimadalan.pe.hu/yemekler/resimler/${incomingFood.yemek_resim_adi}"

        // Glide ile resmi yükle
        Glide.with(requireContext())
            .load(imageUrl)
            .into(binding.ivFood)

        // sepete ekle butonuna basıldığında web servis tetiklenecek
        binding.btnAddToCart.setOnClickListener {
            val foodQuantity : Int = binding.tvFoodQuantity.text.toString().toInt()
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("İşlem Başarılı!")
                .setMessage("${foodQuantity} adet ${incomingFood.yemek_adi} başarıyla sepete eklenmiştir.")
                .setPositiveButton("Sepete Git") { d, i ->
                    val gecis = FoodDetailFragmentDirections.foodDetailToShoppingCart()
                    it.findNavController().navigate(gecis)
                }
                .setNegativeButton("Alışverişe Devam Et"){ d, i ->
                    val detayToMainPageGecis = FoodDetailFragmentDirections.foodDetailToMainPage()
                    it.findNavController().navigate(detayToMainPageGecis)
                }
                .show()
            viewModel.sepeteYemekEkle(incomingFood.yemek_adi,
                                      incomingFood.yemek_resim_adi,
                                      incomingFood.yemek_fiyat,
                                      foodQuantity,
                                      "anil_cemal_yasar_deneme")
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : FoodDetailViewModel by viewModels()
        viewModel = tempViewModel
    }

}