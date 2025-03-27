package com.daviddev.passwordmanager

import android.app.Application
import android.util.Log
import androidx.room.Room
import com.daviddev.passwordmanager.Room.AccountDataDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PasswordManager : Application() {
    // ... your code here ...
  /*  lateinit var database: AccountDataDataBase
        private set*/

    /*override fun onCreate() {
        super.onCreate()
        Log.i("Seguimiento","Clase de la aplicación PasswordManager creada." )
        /*database = Room.databaseBuilder(
            applicationContext,
            AccountDataDataBase::class.java,
            "AccountData.db" // Your database file name
        ).build()*/
    }*/
}