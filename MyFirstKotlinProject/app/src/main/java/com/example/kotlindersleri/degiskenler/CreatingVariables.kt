package com.example.kotlindersleri.degiskenler

fun main() {
    var age : Int = 34
    var id = 1
    var productName = "Mont"
    var productImageUrl = "mont.jpg"
    var productScore = 4.7
    var productPrice = 4500
    var productStockStatus : Boolean = true

    println("ID: $id")
    println("Product Name: $productName")
    println("Product Image URL: $productImageUrl")
    println("Product Price: $productPrice")
    println("Product Score: $productScore")
    println("Product Stock Status: $productStockStatus")

    // Constants - Sabitler ( values wont be changed, has positive impact on performance
    val number = 50

    // Type Casting ( toInt(), toString(), usw. )
    // 1 - Converting from numerical type to numerical type ( f.e from int to double )
    val d = 89.56
    val i = 34
    val result = d.toInt()
    var result2 = i.toDouble()
    println(result)
    println(result2)

    // 2 - Converting from numerical type to string
    val num = 85
    var res3 = num.toString() // "85"
    println(res3)

    // 3 - converting from text to numerical
    val text = "81T"
    var res4 = text.toIntOrNull()
    if (res4 != null) {
        println(res4)
    } else {
        println("Entered number is not in correct format")
    }



//    println("Product ID: " + id + "\n" +
//            "Product Name " + productName + "\n" +
//            "Product Image URL " + productImageUrl + "\n" +
//            "Product Score " + productScore + "\n" +
//            "Product Price " + productPrice + "\n" +
//            "Product Stock Status " + productStockStatus + "\n"
//    )
//    println("ID: " + id)
//    println("Product Name: " + productName)
//    println("Product Image URL: " + productImageUrl)
//    println("Product Price: " + productPrice)
//    println("Product Score: " + productScore)
//    println("Product Stock Status: " + productStockStatus)


}