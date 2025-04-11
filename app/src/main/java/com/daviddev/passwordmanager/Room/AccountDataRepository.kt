package com.daviddev.passwordmanager.Room

//com.example.myapplication.Room.DatabaseDAO


import com.daviddev.passwordmanager.Model.KeyValueAccountData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class accountDataRepository @Inject constructor(private val accountDataDatabaseDao: AccountDataDatabaseDao) {

    suspend fun addAccountData(accountData: KeyValueAccountData) = accountDataDatabaseDao.insert(accountData)
    suspend fun updateAccountData(accountData: KeyValueAccountData) = accountDataDatabaseDao.update(accountData)
    suspend fun deleteAccountData(accountData: KeyValueAccountData) = accountDataDatabaseDao.delete(accountData)
    fun getAllAccountData(): Flow<List<KeyValueAccountData>> =accountDataDatabaseDao.getAllAccountData().flowOn(Dispatchers.IO).conflate()
    fun getAccountDataById(id:Long): Flow<KeyValueAccountData> = accountDataDatabaseDao.getAccountDataById(id).flowOn(Dispatchers.IO).conflate()
    fun getAccountsId(): Flow<List<Long>> = accountDataDatabaseDao.getAccountsId().flowOn(Dispatchers.IO).conflate()
    fun getMaxAccountId(): Flow<Long> = accountDataDatabaseDao.getMaxAccountId().flowOn(Dispatchers.IO).conflate()
    fun getAccountData(accountId: Long): Flow<List<KeyValueAccountData>> = accountDataDatabaseDao.getAccountData(accountId).flowOn(Dispatchers.IO).conflate()
}