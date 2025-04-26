package com.example.kotlindersleri.nesne_tabanli_programlama

/*
* Kotlin'de Encapsulation prensibi doğrultusunda getter/setter methodları yok
* This = bulunduğu sınıfı temsil eder
* super keywordü inheritance ile superclassı ifade eder
* data keywordünü sınıfın başına eklersek Encapsulation methodları getter/setter methodlar oluşmuş oluyor
* */
class Food(var id:Int,var name:String,var price: Double) {
    // Constructor - init fonksiyonu
    init {
        println("**** Nesne oluştu ****")
    }
    fun bilgiAl() {
        println("Food Info")
        println("Id         : ${this.id}")
        println("Name       : ${this.name}")
        println("Price      : ${this.price}")
    }
}