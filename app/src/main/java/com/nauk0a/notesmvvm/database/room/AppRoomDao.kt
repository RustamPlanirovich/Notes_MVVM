package com.nauk0a.notesmvvm.database.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nauk0a.notesmvvm.models.AppNote

@Dao
interface AppRoomDao {
    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): LiveData<List<AppNote>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: AppNote)

    @Delete
    suspend fun delete(note: AppNote)
}