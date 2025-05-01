package com.example.kotlindersleri.collections

fun main() {

    // Definition
    val fruits = HashSet<String>()

    // Inserting elements ( insertion order will be ignored )
    fruits.add("Elma")
    fruits.add("Muz")
    fruits.add("Kiraz")
    println(fruits)

    // Inserting an element which already exists in the set ( there will be no changes in the set )
    fruits.add("Elma")
    println(fruits)

    // Find size of the hast set, how many unique value contains
    println(fruits.size)

    // Accessing an element with index
    val y = fruits.elementAt(2)
    println(y)

    for ((index, fruit) in fruits.withIndex()) {
        println("Index: $index. -> $fruit")
    }

    // Removing an element, element name must be given, not its index
    fruits.remove("Muz")
    println(fruits)

    // Clearing set
    fruits.clear()
    println(fruits)

    // HashMap JSON veri yapısına benzemektedir ( Key-Value Pairs )
    val cities = HashMap<Int, String>()
    cities.put(34, "Istanbul")
    cities.putIfAbsent(35, "Izmir")
    cities[41] = "Kocaeli"

    println(cities)

    // Updating value of a key
    cities[41] = "Izmit"
    println(cities)

    // Reading data through key
    println(cities.get(34))

    // Size of map
    println("Size ${cities.size}")

    // Loop over hash map
    for ((key, value) in cities) {
        println("$key -> $value")
    }

    // Removing an element from hash map
    cities.remove(34)
    println(cities)

    // Clearing hash map
    cities.clear()
    println(cities)
}