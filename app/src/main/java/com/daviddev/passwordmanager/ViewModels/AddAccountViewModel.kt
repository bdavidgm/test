package com.daviddev.passwordmanager.ViewModels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.daviddev.passwordmanager.Model.KeyValueAccountData
import com.daviddev.passwordmanager.Room.accountDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.Instant.now
import javax.inject.Inject


@HiltViewModel
class AddAccountViewModel  @Inject constructor(private val repository: accountDataRepository) : ViewModel() {
    init{
        Log.i("Seguimiento","desde el constructor de AddAccountViewModel ." )
    }
   var accountData = mutableStateOf(KeyValueAccountData())



}