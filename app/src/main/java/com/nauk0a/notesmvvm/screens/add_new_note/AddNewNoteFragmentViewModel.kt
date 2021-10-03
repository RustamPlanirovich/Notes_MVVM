package com.nauk0a.notesmvvm.screens.add_new_note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.nauk0a.notesmvvm.models.AppNote
import com.nauk0a.notesmvvm.utilits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewNoteFragmentViewModel(application: Application) : AndroidViewModel(application) {

    fun insert(note: AppNote, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.Main) {
            REPOSITORY.insert(note) {
                onSuccess()
            }
        }
    }
}