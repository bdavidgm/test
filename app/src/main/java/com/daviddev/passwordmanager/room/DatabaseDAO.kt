package com.daviddev.passwordmanager.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.daviddev.passwordmanager.constants.Constants
import com.daviddev.passwordmanager.constants.Constants.Companion.STATUS_ACCOUNT
import com.daviddev.passwordmanager.constants.Constants.Companion.STATUS_TEMPLATE
import kotlinx.coroutines.flow.Flow
import com.daviddev.passwordmanager.room.model.KeyValueAccountData

@Dao // Data Access Observer
interface AccountDataDatabaseDao {
    // Crud


    @Query("SELECT * FROM KeyValueAccountData where status = '$STATUS_TEMPLATE'")
    fun getAllTemplate(): Flow<List<KeyValueAccountData>>

    @Query("SELECT * FROM KeyValueAccountData where status = '$STATUS_TEMPLATE' AND key = :key")
    fun getTemplatesByKey(key: String): Flow<List<KeyValueAccountData>>

    @Query("SELECT * FROM KeyValueAccountData where status = '$STATUS_TEMPLATE' AND account_id = :AccounntID")
    fun getTemplatesByAccoountID(AccounntID: Long): Flow<List<KeyValueAccountData>>

    @Query("SELECT * FROM KeyValueAccountData where status = '$STATUS_TEMPLATE' AND key = '${Constants.KEY_ACCOUNT_NAME}'")
    fun getAllTemplateNames(): Flow<List<KeyValueAccountData>>

    @Query("SELECT * FROM KeyValueAccountData where status = '$STATUS_ACCOUNT'")
    fun getAllAccountData(): Flow<List<KeyValueAccountData>>

    @Query("SELECT * FROM KeyValueAccountData WHERE id = :id AND status = '$STATUS_ACCOUNT'")
    fun getAccountDataById(id: Long): Flow<KeyValueAccountData>

   // @Query("SELECT * FROM KeyValueAccountData WHERE key = :key AND id in (SELECT MIN(id) FROM KeyValueAccountData where key = :key group by account_id )")
   @Query("SELECT * FROM KeyValueAccountData WHERE key = :key AND status = '$STATUS_ACCOUNT' ORDER BY id ASC")
    fun getAccountDataByKey(key: String): Flow<List<KeyValueAccountData>>

    @Query("SELECT DISTINCT account_id FROM KeyValueAccountData where status = '$STATUS_ACCOUNT' ORDER BY account_id")
    fun getAccountsId(): Flow<List<Long>>

    @Query("SELECT MAX(account_id)  FROM KeyValueAccountData")
    fun getMaxAccountId(): Flow<Long>

    @Query("SELECT * FROM KeyValueAccountData WHERE account_id = :accountId and status = '$STATUS_ACCOUNT' ORDER BY id DESC")
    fun getAccountData(accountId: Long): Flow<List<KeyValueAccountData>>

    @Query("SELECT COUNT(*) FROM KeyValueAccountData where status = '$STATUS_ACCOUNT'")
    fun getAccountDataCount(): Flow<Long>

    @Query("DELETE FROM KeyValueAccountData")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(accountData: KeyValueAccountData)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(accountData: KeyValueAccountData)

    @Delete
    suspend fun delete(accountData: KeyValueAccountData)

}