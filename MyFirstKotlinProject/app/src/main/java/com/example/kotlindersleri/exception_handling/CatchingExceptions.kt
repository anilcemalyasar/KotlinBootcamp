package com.example.kotlindersleri.exception_handling

fun main() {

    // Error Types
    // 1. Compile Error: Kodlama yaparken oluşur
//    val sayi = 100
//    sayi = 50

    // 2. Runtime Error - Exceptions
    val x = 10
    val y = 0
    try {
        println("${x/y}")
        println("İşlem tamamlandı")
    } catch (e: Exception) {
//        println(e.message)
        println("Division by zero is not allowed!")
    } finally {
        println("This line of code will always run")
    }

}