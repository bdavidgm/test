package com.daviddev.passwordmanager.di

import com.daviddev.passwordmanager.room.AccountDataDataBase
import com.daviddev.passwordmanager.room.AccountDataDatabaseDao

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesAccountDataDao(accountDataDataBase: AccountDataDataBase) : AccountDataDatabaseDao {
        return accountDataDataBase.accountDataDao()
    }

    @Singleton
    @Provides
    fun providesAccountDataDataBase(@ApplicationContext context : Context): AccountDataDataBase {
        return Room.databaseBuilder(
            context = context,
            AccountDataDataBase::class.java,
            name = "AccountData"
        ).build()
    }

}