package com.example.kotlindersleri.collections

fun main() {

    var fruits = ArrayList<String>()
    fruits.add("Elma")
    fruits.add("Muz")
    fruits.add("Armut")
    fruits.add("Portakal")
    println(fruits)

    // Inserting element at specified index
    fruits.add("Kiraz")

    // Reading element with index
    println(fruits.get(2))

    println("Size of the fruits array: ${fruits.size}")

    for ((index, fruit) in fruits.withIndex()) {
        println("Index: $index. -> $fruit")
    }

    // Removing an element with index
    fruits.removeAt(2)
    println(fruits)

    fruits.clear()
    println(fruits)


}