package com.daviddev.passwordmanager.Room
//com.example.myapplication.Room.AccountDataBase.kt


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.daviddev.passwordmanager.Room.AccountDataDatabaseDao
import com.daviddev.passwordmanager.Room.AccountDataDataBase
import com.daviddev.passwordmanager.Model.AccountData
import com.daviddev.passwordmanager.Model.AccountName
import com.daviddev.passwordmanager.Room.Converter

@Database(entities = [AccountData::class, AccountName::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class AccountDataDataBase: RoomDatabase() {
    abstract fun accountDataDao() : AccountDataDatabaseDao
}
