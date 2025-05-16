package com.example.odev6.data.entity

import java.io.Serializable

data class Product(var id: Int,
                   var name: String,
                   var price: Double,
                   var ramCapacity: Int,
                   var ssdCapacity: Int,
                   var reviewScore: Double,
                   var favoriteCount: Int,
                   var image: String) : Serializable {
}