package com.nauk0a.notesmvvm.screens.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.nauk0a.notesmvvm.models.AppNote
import com.nauk0a.notesmvvm.utilits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteFragmentViewModel(application: Application) : AndroidViewModel(application) {

    fun delete(note: AppNote, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.Main) {
            REPOSITORY.delete(note){
                onSuccess()
            }
        }
    }
}