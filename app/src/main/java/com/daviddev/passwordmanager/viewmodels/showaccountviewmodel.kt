package com.daviddev.passwordmanager.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daviddev.passwordmanager.constants.Constants
import com.daviddev.passwordmanager.room.AccountDataRepository
import com.daviddev.passwordmanager.room.model.KeyValueAccountData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.launch
import java.util.Collections
import javax.inject.Inject


@HiltViewModel
class ShowAccountsViewModel @Inject constructor(private val repository: AccountDataRepository) : ViewModel() {
    private val _acccountList = MutableStateFlow<List<KeyValueAccountData>>(emptyList())
    val acccountList = _acccountList.asStateFlow()

    private val _acccountsNames = MutableStateFlow<List<KeyValueAccountData>>(emptyList())
    val acccountsNames = _acccountsNames.asStateFlow()

    private val _SelectedAccount = MutableStateFlow<List<KeyValueAccountData>>(emptyList())
    val SelectedAccount = _SelectedAccount.asStateFlow()

    private val _accountDataCount = MutableStateFlow<Long>(0L)
    val accountDataCount = _accountDataCount.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAccountDataByKey(Constants.KEY_ACCOUNT_NAME).collect{ item ->
                if (item.isNullOrEmpty()){
                    _acccountsNames.value = Collections.emptyList()
                } else {
                    _acccountsNames.value = item

                }
            }
        }

        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllAccountData().collect { item ->
                if (item.isNullOrEmpty()) {
                    _acccountList.value = Collections.emptyList()
                } else {
                    _acccountList.value = item

                }
            }
        }

        viewModelScope.launch(Dispatchers.IO) {
            repository.getAccountDataCount().collect { count ->
                _accountDataCount.value = count

            }
        }
    }

    fun getAccountDataCount(): Long {
        return accountDataCount.value
    }
    fun loadSingleAccountData(id: Long){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAccountData(id).collect { item ->
                if (item.isNullOrEmpty()) {
                    _SelectedAccount.value = Collections.emptyList()

                } else {
                    _SelectedAccount.value = item

                }
            }
        }

        /*
     val ad= acccountList.value.filter { it.id == id }
     return ad
        */
    }

    fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }
}