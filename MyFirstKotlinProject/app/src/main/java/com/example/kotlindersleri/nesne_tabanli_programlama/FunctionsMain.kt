package com.example.kotlindersleri.nesne_tabanli_programlama

fun main() {

    val functions = Functions()

    // void = Unit
    functions.greet("Anil")

    // return
    var greetings : String = functions.greet2("Anil")
    println("Incoming data: $greetings")

    println(functions.add(11, 22))
    println(functions.add(23, 34, 45))
}