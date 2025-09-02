package com.daviddev.passwordmanager.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daviddev.passwordmanager.constants.Constants
import com.daviddev.passwordmanager.room.AccountDataRepository
import com.daviddev.passwordmanager.room.model.KeyValueAccountData
import com.daviddev.passwordmanager.views.KeyValueView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class AddAccountViewModel  @Inject constructor(private val repository: AccountDataRepository) : ViewModel() {
    //private val _acccountList = MutableStateFlow<List<KeyValueAccountData>>(emptyList())
    //val acccountList = _acccountList.asStateFlow()
    init{

    }

    fun addAccount(dataList: List<KeyValueAccountData>){
        viewModelScope.launch(Dispatchers.IO) {
            // Usar first() para obtener el primer valor emitido y luego completar
            val maxAccountId = repository.getMaxAccountId().first()
            val newAccountId = (maxAccountId ?: 0L) + 1
            
            dataList.forEach { data ->
                repository.addAccountData(
                    KeyValueAccountData(
                        id = 0,
                        accountId = newAccountId,
                        key = data.key,
                        value = data.value,
                        status = Constants.STATUS_ACCOUNT,
                        type = data.type,
                        creationDate = LocalDateTime.now()
                    )
                )
            }
        }
    }

  // var accountData = mutableStateOf(KeyValueAccountData())

}