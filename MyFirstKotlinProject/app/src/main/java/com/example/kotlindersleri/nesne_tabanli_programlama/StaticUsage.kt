package com.example.kotlindersleri.nesne_tabanli_programlama

fun main() {

    var a = ClassA()


    // Statik erişim
    println("X = ${ClassA.x}")
    ClassA.method()


    // Standart nesne tabanlı erişim
//    println("X = ${a.x}")
//    a.method()
//
//    // Sanal nesne, virtual object - nameless object
//    println("X = ${ClassA().x}")   // 1. nesne oluşturuluyor
//    ClassA().method()              // 2. nesne oluşturuluyor
}