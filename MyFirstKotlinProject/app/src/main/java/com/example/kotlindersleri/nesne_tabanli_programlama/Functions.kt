package com.example.kotlindersleri.nesne_tabanli_programlama

class Functions {

    // void functions, they don't return any data
    fun greet(name: String) {
        println("Hello $name")
    }

    // return functions always return data
    fun greet2(name: String) : String {
        return "Hello $name"
    }

    // Method overloading ( sınıf içerisinde aynı isimde methodların farklı parametrelerle overload edilmesi )
    fun add(num1:Int, num2:Int) : Int {
        return num1 + num2
    }

    fun add(num1: Int, num2: Int, num3: Int) : Int {
        return num1 + num2 + num3
    }
}