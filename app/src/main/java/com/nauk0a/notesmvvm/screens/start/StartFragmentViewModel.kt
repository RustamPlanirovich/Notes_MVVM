package com.nauk0a.notesmvvm.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.nauk0a.notesmvvm.database.room.AppRoomDatabase
import com.nauk0a.notesmvvm.database.room.AppRoomRepository
import com.nauk0a.notesmvvm.utilits.REPOSITORY
import com.nauk0a.notesmvvm.utilits.TYPE_FIREBASE
import com.nauk0a.notesmvvm.utilits.TYPE_ROOM

class StartFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application

    fun initDatabase(type: String, onSucces: () -> Unit) {
        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSucces()
            }
            TYPE_FIREBASE -> {

            }
        }
    }
}