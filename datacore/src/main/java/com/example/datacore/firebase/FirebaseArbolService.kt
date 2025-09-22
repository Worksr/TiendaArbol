package com.example.datacore.firebase

import com.example.datacore.model.Arbol
import com.google.firebase.firestore.FirebaseFirestore


class FirebaseArbolService (
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
) {
    private val collection = firestore.collection("users")

    suspend fun uploadArbol(arbol: Arbol){
        collection.document(arbol.id).set(arbol.toMap()).await()
    }

    suspend fun deleteArbol(arbol: Arbol){
        collection.document(arbol.id).delete().await()
    }
    suspend fun getAllArbol(): List<Arbol>{
        val snapshot = collection.get().await()
        return snapshot.documents.mapNotNull {
            it.data?.let {data -> Arbol.fromMap(data)}
        }
    }
}

