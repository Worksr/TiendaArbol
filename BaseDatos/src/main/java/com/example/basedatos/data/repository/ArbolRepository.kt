package com.example.basedatos.data.repository

import com.example.basedatos.data.data.Arbol
import com.example.basedatos.data.data.ArbolDAO
import kotlinx.coroutines.flow.Flow

class ArbolRepository(private val arbolDao: ArbolDAO) {
    fun getAllArbol(): Flow<List<Arbol>> = arbolDao.getAllArbol()
    //POST
    suspend fun insert(arbol: Arbol){
        arbolDao.insertArbol(arbol)
    }
    //PUT
    suspend fun update(arbol: Arbol){
        arbolDao.updateArbol(arbol)
    }
    //DELETE
    suspend fun delete(arbol: Arbol){
        arbolDao.deleteArbol(arbol)
    }

}