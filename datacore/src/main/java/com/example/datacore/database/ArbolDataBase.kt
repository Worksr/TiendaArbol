package com.example.datacore.database

import androidx.room.Database

@Database(
    entities = [Arbol::class],
    version = 1,
    exportSchema = false
)

abstract class ArbolDataBase : RoomDatabase(){
    abstract fun arbolDao() : ArbolDAO
}