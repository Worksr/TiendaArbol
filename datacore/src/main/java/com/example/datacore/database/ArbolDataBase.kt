package com.example.datacore.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.datacore.dao.ArbolDAO
import com.example.datacore.model.Arbol

@Database(
    entities = [Arbol::class],
    version = 1,
    exportSchema = false
)

abstract class ArbolDataBase : RoomDatabase(){
    abstract fun arbolDao() : ArbolDAO
}