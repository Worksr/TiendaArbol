package com.example.datacore.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.UUID

@Entity(tableName = "Arbol")
data class Arbol (

    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val fecha: String,
    val hora: String,
    val producto: String,
    val precio: String,
    val notas: String? = null
//    @ColumnInfo(name = "title") val title: String,
//    @ColumnInfo(name = "description") val description: String,
//    @ColumnInfo(name = "date") val date: LocalDateTime
) {
    fun toMap(): Map <String, Any?> = mapOf(
        "id" to id,
        "fecha" to fecha,
        "hora" to hora,
        "producto" to producto,
        "precio" to precio,
        "notas" to notas
    )
}