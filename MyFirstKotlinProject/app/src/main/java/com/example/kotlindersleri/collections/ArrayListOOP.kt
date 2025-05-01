package com.example.kotlindersleri.collections

fun main() {

    var film1 = Film(1, "Babam ve Oğlum", 50.00)
    var film2 = Film(2, "Neşeli Hayatlar", 35.00)
    var film3 = Film(3, "Babam ve Oğlum", 80.00)

    var filmList = ArrayList<Film>()
    filmList.add(film1)
    filmList.add(film2)
    filmList.add(film3)

    for (film in filmList) {
        println("${film.id} : ${film.name} - ${film.price} TL")
    }

    // Sorting
    println("-----Fiyatı Artan Sıralama ( ASCENDING ORDER )-----")
    val sorting1 = filmList.sortedWith(compareBy { it.price })
    for (film in sorting1) {
        println("${film.id} : ${film.name} - ${film.price} TL")
    }

    println("-----Fiyatı Azalan Sıralama ( DESCENDING ORDER )-----")
    val sorting2 = filmList.sortedWith(compareByDescending { it.price })
    for (film in sorting2) {
        println("${film.id} : ${film.name} - ${film.price} TL")
    }

    // Filtering ( filtreleme )
    println("----- Fiyata Göre Filtrelenmiş ( 40 TL'den fazla, 80 TL'den az olan ) -----")
    val filtering1 = filmList.filter { it -> it.price > 40 && it.price < 80}
    for (film in filtering1) {
        println("${film.id} : ${film.name} - ${film.price} TL")
    }

    println("----- Ada göre Filtrelenmiş -----")
    val filtering2 = filmList.filter { it -> it.name.contains("at") }
    for (film in filtering2) {
        println("${film.id} : ${film.name} - ${film.price} TL")
    }
}