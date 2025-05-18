package com.example.odev7todoapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "toDos")
data class Todo(@PrimaryKey(autoGenerate = true)
                @ColumnInfo(name = "id") @NotNull var id: Int,
                @ColumnInfo(name = "name") @NotNull var name: String,
                @ColumnInfo(name = "start_date") @NotNull var startDate: String,
                @ColumnInfo(name = "end_date") @NotNull var endDate: String) : Serializable {
}