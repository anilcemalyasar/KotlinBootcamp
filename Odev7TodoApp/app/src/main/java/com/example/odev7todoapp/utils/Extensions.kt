package com.example.odev7todoapp.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import java.text.SimpleDateFormat
import java.util.Locale

fun Navigation.doNavigate(v: View, id: Int) {
    findNavController(v).navigate(id)
}

fun Navigation.doNavigate(v: View, id: NavDirections) {
    findNavController(v).navigate(id)
}

fun String.convertDateToSqlFormat(s: String, inputDateFormat: String, outputDateFormat: String) : String {
    val girisFormat = SimpleDateFormat(inputDateFormat, Locale.getDefault())
    val cikisFormat = SimpleDateFormat(outputDateFormat, Locale.getDefault())
    val tarih = girisFormat.parse(s)
    return cikisFormat.format(tarih!!)
}
