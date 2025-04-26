package com.example.kotlindersleri.standart_programlama

// The for loop iterates through anything that provides an iterator.
fun main() {
    for (i in 1..3) {
        print("$i ")
    }

    // 10 ile 20 arasında increment 5'er 5'er artacak
    for (i in 10..20 step 5) {
        println("Loop 2: $i")
    }

    // 6 dan 0 a ikişer ikişer azaltarak
    for (x in 6 downTo 0 step 2) {
        println("Loop 3 : $x")
    }

    // while checks the condition and, if it's satisfied, processes the body and then returns to the condition check.
    var counter : Int = 1
    while (counter < 4) {
        println("Counter: $counter")
        counter++  // to prevent this loop being infinite loop, we increment our condition variable
    }

    /*
    * Kotlin has three structural jump expressions:
    * return by default returns from the nearest enclosing function or anonymous function.
    * break terminates the nearest enclosing loop.
    * continue proceeds to the next step of the nearest enclosing loop.
    * */
    for (i in 1..5) {
        if (i == 3) continue
        println("Loop 4: $i")
    }
}