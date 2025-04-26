package com.example.kotlindersleri.nesne_tabanli_programlama

fun main() {

//    var result : Int = 5.multiply(2) // Extension fonksiyon ise
    var result : Int = 5 multiply 2   // infix fonksiyon varsa
    println(result)
}

//fun Int.multiply(number: Int) : Int {
//    return this * number // buradaki this integer sınıfını temsil ediyor
//}
infix fun Int.multiply(number: Int) : Int {
    return this * number // buradaki this integer sınıfını temsil ediyor
}