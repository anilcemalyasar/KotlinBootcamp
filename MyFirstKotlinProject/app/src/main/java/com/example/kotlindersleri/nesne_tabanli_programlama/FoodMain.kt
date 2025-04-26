package com.example.kotlindersleri.nesne_tabanli_programlama

fun main() {

    // Creating instance/object
    // Kotlin does not have a new keyword.
    val food1 = Food(1, "Köfte", 249.99)
    food1.bilgiAl()

    val food2 = Food(2, "Balık", 159.99)
    food2.bilgiAl()
//    // Reading values
//    println("--------------------Food 1 Info------------------")
//    println("Food 1 Id      : ${food1.id}")
//    println("Food 1 Name    : ${food1.name}")
//    println("Food 1 Id      : ${food1.price}")
//
//    println("--------------------Food 2 Info------------------")
//    println("Food 2 Id      : ${food2.id}")
//    println("Food 2 Name    : ${food2.name}")
//    println("Food 2 Id      : ${food2.price}")
//
//    // Assigning value
//    food1.price = 359.99
//    println("--------------------Food 1 Info Changed------------------")
//    println("Food 1 Id      : ${food1.price}")


}