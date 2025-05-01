package com.example.kotlindersleri.nesne_tabanli_programlama.kalitim

class ClassB : MyInterface {
    override var degisken: Int = 100

    override fun method1() {
        println("Method1 çalıştı")
    }

    override fun method2(): String {
        return "Method 2 çalıştı"
    }
}