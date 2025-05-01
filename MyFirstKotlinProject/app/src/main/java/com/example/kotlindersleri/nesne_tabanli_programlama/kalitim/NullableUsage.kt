package com.example.kotlindersleri.nesne_tabanli_programlama.kalitim

fun main() {

    /*
    * Nullable, Null Safety, Optional(Swift)
    * In our applications sometimes objects are created as null
    * */
    // 1. Definition
    var message: String? = null

    message = "Merhaba"

    // Use Case 1: Soru işareti varsa uygulama çökmez
    println("Use Case 1 : ${message?.uppercase()}")

    // Use Case 2: Null olmayacağına emin olduğumuz kodlarda kullanabiliriz, yoksa exceptiona düşer
//    println("Use Case 2 : ${message!!.uppercase()}")

    // Use Case 3: Null kontrolü
    if (message != null) {
        println("Use Case 3: ${message.uppercase()}")
    } else {
        println("Variable is assigned to null")
    }

    message?.let {
        println("Use Case 4: ${it.uppercase()}")
    }

    /*
    * lateinit sadece var ile kullanılır, çünkü val da direkt değeri sabit olarak vermekteyiz
    * daha sonrasında info değişkenine kesinlikle değer atanacağını söylüyorum
    * lateinit primitive veri tiplerinde kullanılamaz
    * */
    lateinit var info : String
    // println(info) // kotlin.UninitializedPropertyAccessException: lateinit property info has not been initialized


}