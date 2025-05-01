package com.example.kotlindersleri.nesne_tabanli_programlama.kalitim

fun main() {

    /*
    * Super class olduğu için kendi methodunu çalıştırıyor
    * */
    val animal = Animal()
    animal.sesCikar()

    /*
    * Kalıtım aldığı sınıftaki methodu override etmediği için super classın methodunu çalıştırıyor
    * */
    val memeli = Memeli()
    memeli.sesCikar()

    /*
    * Superclass daki ses çıkar methodunu kedi sınıfı override ettiği için kendi methodu çalışacak
    * */
    val cat = Cat()
    cat.sesCikar()

    /*
    * Superclass daki ses çıkar methodunu köpek sınıfı override ettiği için kendi methodu çalışacak
    * */
    val dog = Dog()
    dog.sesCikar()

    /*
    * Nesneler arasında tip dönüşümü yapılacaksa arada kalıtım bağının olması gerekiyor
    * Upcasting - Downcasting
    * */
}