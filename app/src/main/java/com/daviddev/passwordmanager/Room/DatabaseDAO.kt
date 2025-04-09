package com.daviddev.passwordmanager.Room
//
//com.example.myapplication.Room.AccountDataRepository.kt
//com.example.myapplication.Room.AccountDataBase.kt
//com.example.myapplication.Model.RoomTable.kt
//com.example.myapplication.DI.HiltModule.kt


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import com.daviddev.passwordmanager.Model.AccountData


@Dao // Data Access Observer
interface AccountDataDatabaseDao {

    // Crud
    @Query("SELECT * FROM AccountData")
    fun getAllAccountData(): Flow<List<AccountData>>

    @Query("SELECT * FROM AccountData WHERE id = :id")
    fun getAccountDataById(id: Long): Flow<AccountData>

    @Query("SELECT * FROM AccountData WHERE account_id = :accountId ORDER BY creation_date DESC LIMIT 1")
    fun getLastAccountData(accountId: Long): Flow<AccountData>

    @Query("SELECT * FROM AccountData WHERE account_id = :accountId ORDER BY creation_date DESC")
    fun getAllAccountData(accountId: Long): Flow<List<AccountData>>

   /* @Query("SELECT account_id FROM AccountName WHERE account_name = :accountName")
    suspend fun getAccountID(accountName: String): Long

    @Query("SELECT account_name FROM AccountName")
    suspend fun getAllAccountName(): flow<List<String>>*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(accountData: AccountData)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(accountData: AccountData)

    @Delete
    suspend fun delete(accountData: AccountData)

}