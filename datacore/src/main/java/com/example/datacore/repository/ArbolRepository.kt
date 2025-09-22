package com.example.datacore.repository

import com.example.datacore.dao.ArbolDAO
import com.example.datacore.firebase.FirebaseCitaService
import com.example.datacore.model.Arbol
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class ArbolRepository(
    private val arbolDAO: ArbolDAO,
    private val firebaseService: FirebaseCitaService
){
    fun getAllArbol(): Flow<List<Arbol>> = arbolDAO.getAllArbol()

    suspend fun insertArbol(arbol: Arbol){
        arbolDAO.insertArbol(arbol)
        try {
            firebaseService.uploadArbol(arbol)
        } catch (_: Exception){

        }
    }
    suspend fun updateArbol(arbol: Arbol){
        arbolDAO.updateArbol(arbol)
        try{
            firebaseService.uploadArbol(arbol)
        } catch (_: Exception) { }
    }

    suspend fun deleteArbol(arbol: Arbol) {
        arbolDAO.deleteArbol(arbol)
        try {
            firebaseService.deleteArbol(arbol)
        } catch (_: Exception) { }
    }

    suspend fun syncFromFirebase() {
        try {
            val remoteArbol = firebaseService.getAllArbol()
            val localArbol = arbolDAO.getAllArbol().first()

            remoteArbol.forEach { remote ->
                if (localArbol.none {it.id == remote.id}) {
                    arbolDAO.insertArbol(remote)
                }
            }
        } catch (_: Exception){

        }
    }
}