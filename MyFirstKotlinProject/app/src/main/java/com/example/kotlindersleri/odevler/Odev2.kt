package com.example.kotlindersleri.odevler

fun main() {

    var celsius = 20
    println("$celsius°C = ${toFahrenheit(celsius)}°F")

    // Kenarları parametre olarak verilen dikdörtgenin çevresini hesaplayan fonksiyon
    calculateArea(8, 6, 6, 8)

    var number = 6
    println("$number! = ${recursiveFactorial(number)}") // recursive Factorial
    println("$number! = ${factorialWithLoop(number)}") // factorial through loop

    var word : String = "Parametre olarak girilen metin"
    var letter: Char = 'a'
    countLetter(letter, word)

    var numberOfEdges : Int = 4
    println("4 kenarlı bir şeklin iç açılar toplamı: ${calculateTotalInnerAngles(numberOfEdges)}")

    var totalWorkDay : Int = 25
    println("$totalWorkDay Gün çalışan birisinin alacağı ücret: ${calculateSalary(totalWorkDay)}")

    totalWorkDay = 6
    println("$totalWorkDay Gün çalışan birisinin alacağı ücret: ${calculateSalary(totalWorkDay)}")

    var internetQuota = 50
    var internetUsage = 70
    println("$internetQuota GB kotasına sahip biri $internetUsage GB kullandıysa ödemesi gereken ücret: ${calculateInternetPrice(internetQuota, internetUsage)}")

}

// 4. Parametre olarak girilen kelime içinde kaç adet a harfi olduğunu gösteren bir metod yazınız.
fun countLetter(letter: Char, word: String) {
    var wordLength = word.length
    var count = 0
    for (i in 0..wordLength - 1) {
        if (word[i] == letter) count++
    }

    println("$word kelimesi içinde $count kadar $letter harfi vardır")
}

// Kenarları parametre olarak girilen ve dikdörtgenin çevresini hesaplayan bir metod yazınız.
fun calculateArea(edge1: Int, edge2: Int, edge3: Int, edge4: Int) {
    println("Dikdörtgenin çevresi ${edge1 + edge2 + edge3 + edge4}")
}

// 1. Parametre olarak girilen dereceyi fahrenhiet'a dönüştürdükten sonra geri döndüren bir metod yazınız.
fun toFahrenheit(celsius: Int) : Double{
    return (celsius * 1.8) + 32
}

// Recursive factorial
// 3. Parametre olarak girilen sayının faktoriyel değerini hesaplayıp geri döndüren metodu yazınız.
fun recursiveFactorial(number: Int) : Int {
    if (number == 1) return 1
    return number * recursiveFactorial(number - 1)
}

// 3. Parametre olarak girilen sayının faktoriyel değerini hesaplayıp geri döndüren metodu yazınız.
fun factorialWithLoop(number: Int) : Int {
    var result : Int = 1
    var num = number
    while (num >= 2) {
        result *= num
        num--
    }

    return result
}

// 1. Parametre olarak girilen kenar sayısına göre iç açılar toplamını hesaplayıp sonucu geri gönderen metod yazınız.
fun calculateTotalInnerAngles(edges: Int) : Int {
    return (edges - 2) * 180
}

// 2. Parametre olarak girilen gün sayısına göre maaş hesabı yapan ve elde edilen değeri döndüren metod yazınız.
fun calculateSalary(totalWorkDay: Int) : Int {
    var salary : Int = 0
    if (totalWorkDay * 8 > 160) {
        var overtime = totalWorkDay * 8 - 160
        salary += ( 160 * 10 ) + ( overtime * 20 )
    } else {
        salary += ( totalWorkDay * 8 * 10 )
    }
    return salary
}

// Kota ücreti hesaplaması
fun calculateInternetPrice(quota: Int, usage: Int) : Int {
    var overusage = usage - quota
    return ( quota * 2 ) + (overusage * 4)
}