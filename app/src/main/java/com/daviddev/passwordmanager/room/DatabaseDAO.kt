package com.daviddev.passwordmanager.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import com.daviddev.passwordmanager.room.model.KeyValueAccountData


@Dao // Data Access Observer
interface AccountDataDatabaseDao {

    // Crud
    @Query("SELECT * FROM KeyValueAccountData")
    fun getAllAccountData(): Flow<List<KeyValueAccountData>>

    @Query("SELECT * FROM KeyValueAccountData WHERE id = :id")
    fun getAccountDataById(id: Long): Flow<KeyValueAccountData>

    @Query("SELECT DISTINCT account_id FROM KeyValueAccountData ORDER BY account_id")
    fun getAccountsId(): Flow<List<Long>>

    @Query("SELECT MAX(account_id)  FROM KeyValueAccountData")
    fun getMaxAccountId(): Flow<Long>

    @Query("SELECT * FROM KeyValueAccountData WHERE account_id = :accountId ORDER BY id DESC")
    fun getAccountData(accountId: Long): Flow<List<KeyValueAccountData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(accountData: KeyValueAccountData)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(accountData: KeyValueAccountData)

    @Delete
    suspend fun delete(accountData: KeyValueAccountData)

}