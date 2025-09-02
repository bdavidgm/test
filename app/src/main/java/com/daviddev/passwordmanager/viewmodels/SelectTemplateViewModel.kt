package com.daviddev.passwordmanager.viewmodels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daviddev.passwordmanager.constants.Constants
import com.daviddev.passwordmanager.room.AccountDataRepository
import com.daviddev.passwordmanager.room.model.KeyValueAccountData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.util.Collections
import javax.inject.Inject

@HiltViewModel
class SelectTemplateViewModel @Inject constructor(private val repository: AccountDataRepository) : ViewModel() {
    private val _templatesNames = MutableStateFlow<List<KeyValueAccountData>>(emptyList())
    val templatesNames= _templatesNames.asStateFlow()

    private val _selectedTemplate = MutableStateFlow<List<KeyValueAccountData>>(emptyList())
    val selectedTemplate= _selectedTemplate.asStateFlow()

    /*todo: me falta probar tomar selectedTemplate desde la view con collectasState para ver si de ese modo se toma sin el delay */

    init{
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllTemplateNames().collect{ item ->
                if (item.isNullOrEmpty()){
                    _templatesNames.value = Collections.emptyList()
                } else {
                    _templatesNames.value = item

                }
            }
        }
    }

   /*
    fun selectTemplate(Name:String) {
      viewModelScope.launch(Dispatchers.IO) {
          templatesNames.value.forEach { template ->
              if ((template.key == Constants.KEY_ACCOUNT_NAME) and (template.value == Name)) {
                  repository.getTemplatesByAccoountID(template.accountId).collect() { item ->
                      if (item.isNullOrEmpty())
                          _selectedTemplate.value = Collections.emptyList()
                      else
                          _selectedTemplate.value = item
                  }
              }
          }

      }
  }
  */
    fun msg(context: Context, text:String)
    {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()

    }

    fun selectTemplate(accountId:Long){
        viewModelScope.launch(Dispatchers.IO) {
                  repository.getTemplatesByAccoountID(accountId).collect() { item ->
                        if (item.isNullOrEmpty()) {
                            _selectedTemplate.value = Collections.emptyList()

                        }else {
                            _selectedTemplate.value = item
                        }
                    }

        }


    }

    fun saveAsTemplate(template: List<KeyValueAccountData>)
    {

        viewModelScope.launch(Dispatchers.IO) {

            val id = repository.getMaxAccountId().first()
            val AccountId = (id ?: 0L) + 1
            template.forEachIndexed { index, item ->
                repository.addAccountData(
                    KeyValueAccountData(
                        id = 0,
                        accountId = AccountId,
                        key = item.key,
                        value = if (item.key == Constants.KEY_ACCOUNT_NAME ) item.value else "",
                        status = Constants.STATUS_TEMPLATE,
                        type = item.type,
                        creationDate = LocalDateTime.now()
                    )
                )
                Log.i("Seguimiento"," Agregando plantilla $index  ${item.key}  AccountId:${AccountId}" )
            }
        }
    }
}
