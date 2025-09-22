package com.example.datacore.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ArbolDAO {
    @Query("SELECT * FROM arbol ORDER BY date DESC")
    fun getAllArbol(): Flow<List<Arbol>>

    //POST
    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertArbol(arbol: Arbol)

    //PUT
    @Update
    suspend fun updateArbol(arbol: Arbol)

    //DELETE
    suspend fun deleteArbol(arbol: Arbol)
}