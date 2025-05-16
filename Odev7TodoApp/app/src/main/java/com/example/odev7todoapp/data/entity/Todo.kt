package com.example.odev7todoapp.data.entity

import java.io.Serializable

data class Todo(var id: Int,
           var name: String,
           var startDate: String,
           var endDate: String) : Serializable {
}