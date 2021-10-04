package com.nauk0a.notesmvvm.database.firebase

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.nauk0a.notesmvvm.database.DatabaseRepository
import com.nauk0a.notesmvvm.models.AppNote
import com.nauk0a.notesmvvm.utilits.EMAIL
import com.nauk0a.notesmvvm.utilits.PASSWORD

class AppFirebaseRepository : DatabaseRepository {

    private val mAuth = FirebaseAuth.getInstance()
    override val allNotes: LiveData<List<AppNote>>
        get() = TODO("Not yet implemented")

    override suspend fun insert(note: AppNote, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(note: AppNote, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {
        mAuth.signInWithEmailAndPassword(EMAIL, PASSWORD)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener {
                mAuth.createUserWithEmailAndPassword(EMAIL, PASSWORD)
                    .addOnSuccessListener { onSuccess() }
                    .addOnFailureListener { onFail(it.message.toString()) }
            }
    }

    override fun signOut() {
        mAuth.signOut()
    }
}