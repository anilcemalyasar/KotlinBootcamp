package com.example.kotlindersleri.nesne_tabanli_programlama

fun main() {

    calculatePrice(CannedSize.LARGE, 4)
    calculatePrice(CannedSize.MEDIUM, 55)
}

fun calculatePrice(size: CannedSize, amount: Int) {
    when (size) {
        CannedSize.SMALL -> println("Ücret ${ amount * 104 }")
        CannedSize.MEDIUM -> println("Ücret ${ amount * 207 }")
        CannedSize.LARGE -> println("Ücret ${ amount * 309 }")
    }
}