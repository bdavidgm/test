package com.daviddev.passwordmanager.room
//com.example.myapplication.Room.AccountDataBase.kt


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.daviddev.passwordmanager.Model.KeyValueAccountData

@Database(entities = [KeyValueAccountData::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class AccountDataDataBase: RoomDatabase() {
    abstract fun accountDataDao() : AccountDataDatabaseDao
}
