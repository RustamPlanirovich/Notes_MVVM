package com.nauk0a.notesmvvm.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.nauk0a.notesmvvm.utilits.REPOSITORY

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes = REPOSITORY.allNotes
}