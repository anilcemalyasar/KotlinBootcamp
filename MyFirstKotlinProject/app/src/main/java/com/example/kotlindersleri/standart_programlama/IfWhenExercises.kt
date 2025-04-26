package com.example.kotlindersleri.standart_programlama

fun main() {
    var yas : Int = 15
    if (yas >= 18) {
        println("You can vote")
    } else {
        println("You must be older than 18 to vote")
    }

    /*
    * User Login Credentials Validation
    * */
    val username = "admin"
    val password = 12345
    val number = 10

    if (username == "admin" && password == 12345) {
        println("You've successfully logged in!")
    } else {
        println("Your login credentials are wrong!")
    }

    if (number == 9 || number == 10) {
        println("Number is equal to 9 or 10")
    } else {
        println("Number is anything else from 9 and 10")
    }

    /*
    * WHEN Statement
    * when is a conditional expression that runs code based on multiple possible values or conditions.
    * */
    val x = 2
    when (x) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        else -> println("x is neither 1 or 2")
    }


}