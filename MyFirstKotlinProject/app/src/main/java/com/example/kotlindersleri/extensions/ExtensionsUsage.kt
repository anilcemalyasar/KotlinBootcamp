package com.example.kotlindersleri.extensions

fun main() {
//    val list = mutableListOf(3, 4, 5)
//    println("List Before swapping ${list}") // List Before swapping [3, 4, 5]
//    list.swap(0, 2)
//    println("List After swapping ${list}") // List After swapping [5, 4, 3]
//
//    val myMap = mutableMapOf("A" to 1, "B" to 2, "C" to 3)
//    println("Map Before swapping values ${myMap}") // Çıktı:  {A=1, B=2, C=3}
//    myMap.swapValues("A", "B")
//    println("Map After swapping values ${myMap}") // Çıktı: {A=2, B=1, C=3}

    val range = 1.rangeTo(5)
    println(range.toList()) // [1, 2, 3, 4, 5]

// Aynı şekilde infix kullanımıyla:
    val rangeInfix = 1..5
    println(rangeInfix.toList()) // [1, 2, 3, 4, 5]

    println(3 pow 4) // 81
    println(2 pow 5) // 32
    println(6 pow 3) // 216

}

infix fun Int.pow(exp: Int): Int {

    var result = 1
    for (i in 1..exp) {
        result *= this
    }
    return result
}


fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this', listeyi temsil eder
    this[index1] = this[index2]
    this[index2] = tmp
}

fun <K, V> MutableMap<K, V>.swapValues(key1: K, key2: K) {
    val value1 = this[key1]
    val value2 = this[key2]

    if (key1 != key2 && value1 != null && value2 != null) {
        this[key1] = value2
        this[key2] = value1
    }
}

