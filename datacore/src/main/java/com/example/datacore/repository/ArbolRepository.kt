package com.example.datacore.repository

import com.example.datacore.dao.ArbolDAO
import com.example.datacore.firebase.FirebaseArbolService
import com.example.datacore.model.Arbol
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class ArbolRepository(
    private val arbolDAO: ArbolDAO,
    private val firebaseService: FirebaseArbolService
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
    suspend fun insertFakeData() {
        val fakeArbol = listOf(
            Arbol(fecha = "2025-09-20", hora = "09:00", producto = "Arbol", precio = "100", notas = "Para decoracion"),
            Arbol(fecha = "2025-09-21", hora = "11:00", producto = "Arbol1", precio = "150", notas = "Para cultivar"),
            Arbol(fecha = "2025-09-22", hora = "07:00", producto = "Arbol2", precio = "110", notas = "Para sombra"),
        )

        fakeArbol.forEach {
            arbolDAO.insertArbol(it)
            try {
                firebaseService.uploadArbol(it)
            } catch (_: Exception){

            }
        }
    }
}