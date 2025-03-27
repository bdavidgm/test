package com.daviddev.passwordmanager.Room

//com.example.myapplication.Room.DatabaseDAO


import com.daviddev.passwordmanager.Model.AccountData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class accountDataRepository @Inject constructor(private val accountDataDatabaseDao: AccountDataDatabaseDao) {

    suspend fun addAccountData(accountData: AccountData) = accountDataDatabaseDao.insert(accountData)
    suspend fun updateAccountData(accountData: AccountData) = accountDataDatabaseDao.update(accountData)
    suspend fun deleteAccountData(accountData: AccountData) = accountDataDatabaseDao.delete(accountData)
    fun getAllAccountData() = accountDataDatabaseDao.getAllAccountData().flowOn(Dispatchers.IO).conflate()
    fun getAccountDataById(id:Long): Flow<AccountData> = accountDataDatabaseDao.getAccountDataById(id).flowOn(Dispatchers.IO).conflate()
    suspend fun getLastAccountData(accountId: Long): Flow<AccountData> = accountDataDatabaseDao.getLastAccountData(accountId).flowOn(Dispatchers.IO).conflate()
    suspend fun getAllAccountData(accountId: Long): Flow<List<AccountData>> = accountDataDatabaseDao.getAllAccountData(accountId).flowOn(Dispatchers.IO).conflate()
}