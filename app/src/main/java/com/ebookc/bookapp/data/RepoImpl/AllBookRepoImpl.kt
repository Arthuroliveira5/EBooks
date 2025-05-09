package com.ebookc.bookapp.data.RepoImpl

import android.util.Log
import com.ebookc.bookapp.common.BookCategoryModel
import com.ebookc.bookapp.common.BookModel
import com.ebookc.bookapp.common.ResultState
import com.ebookc.bookapp.domain.repo.AllBookRepo
import com.google.firebase.database.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class AllBookRepoImpl @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase
) : AllBookRepo {

    override fun getAllBooks(): Flow<ResultState<List<BookModel>>> = callbackFlow {
        trySend(ResultState.Loading)

        val ref = firebaseDatabase.reference.child("Books")
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val items = snapshot.children.mapNotNull {
                    it.getValue(BookModel::class.java)
                }
                trySend(ResultState.Success(items)).isSuccess
            }

            override fun onCancelled(error: DatabaseError) {
                trySend(ResultState.Error(error.toException()))
            }
        }

        ref.addValueEventListener(listener)
        awaitClose {
            ref.removeEventListener(listener)
        }
    }

    override fun getAllCategory(): Flow<ResultState<List<BookCategoryModel>>> = callbackFlow {
        trySend(ResultState.Loading)
        Log.d("Firebase", "Buscando categorias...")

        val ref = firebaseDatabase.reference.child("BooksCategory")
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val items = snapshot.children.mapNotNull {
                    Log.d("Firebase", "Item: ${it.value}")
                    it.getValue(BookCategoryModel::class.java)?.also { model ->
                        Log.d("Firebase", "Modelo convertido: $model")
                    }
                }
                Log.d("Firebase", "Total de categorias encontradas: ${items.size}")
                trySend(ResultState.Success(items))
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("Firebase", "Erro ao buscar categorias: ${error.message}")
                trySend(ResultState.Error(error.toException()))
            }
        }

        ref.addValueEventListener(listener)
        awaitClose {
            ref.removeEventListener(listener)
        }
    }

    override fun getAllBooksByCategory(category: String): Flow<ResultState<List<BookModel>>> = callbackFlow {
        trySend(ResultState.Loading)

        val ref = firebaseDatabase.reference.child("Books")
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val items = snapshot.children
                    .mapNotNull { it.getValue(BookModel::class.java)

                    }
                    .filter { it.category == category }


                trySend(ResultState.Success(items)).isSuccess
            }

            override fun onCancelled(error: DatabaseError) {
                trySend(ResultState.Error(error.toException()))
            }

        }

        ref.addValueEventListener(listener)
        awaitClose {
            ref.removeEventListener(listener)
        }
    }
}
