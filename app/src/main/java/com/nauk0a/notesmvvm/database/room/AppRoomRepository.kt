package com.nauk0a.notesmvvm.database.room

import androidx.lifecycle.LiveData
import com.nauk0a.notesmvvm.database.DatabaseRepository
import com.nauk0a.notesmvvm.models.AppNote


class AppRoomRepository(private val appRoomDao: AppRoomDao) : DatabaseRepository {
    override val allNotes: LiveData<List<AppNote>>
        get() = appRoomDao.getAllNotes()

    override suspend fun insert(note: AppNote, onSucces: () -> Unit) {
        appRoomDao.insert(note)
    }

    override suspend fun delete(note: AppNote, onSucces: () -> Unit) {
        appRoomDao.delete(note)
    }
}